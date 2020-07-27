package me.hoon.demoinflearnrestapi.common;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.validation.Errors;

import java.io.IOException;

@JsonComponent
public class ErrorsSerializer extends JsonSerializer<Errors> { //스프링이 제공하는 Errors를 변환하는 Serializer

    @Override
    public void serialize(Errors errors, JsonGenerator gen, SerializerProvider serializerProvider) throws IOException {
        //errors 안에는 에러가 여러개 이기 때문에 startArray와 endArray 사용
        gen.writeStartArray();

        //필드에러
        errors.getFieldErrors().forEach(e -> {
            try{
                gen.writeStartObject();
                gen.writeStringField("field", e.getField());
                gen.writeStringField("objectName", e.getObjectName());
                gen.writeStringField("code", e.getCode());
                gen.writeStringField("defaultMessage", e.getDefaultMessage());

                Object rejectedValue = e.getRejectedValue();
                if(rejectedValue != null){
                    gen.writeStringField("rejectedValue", rejectedValue.toString());
                }
                gen.writeEndObject();
            } catch(IOException e1){
                e1.printStackTrace();
            }

        });

        //글로벌 에러
        errors.getGlobalErrors().forEach(e -> {
            try{
                gen.writeStartObject();
                gen.writeStringField("objectName", e.getObjectName());
                gen.writeStringField("code", e.getCode());
                gen.writeStringField("defaultMessage", e.getDefaultMessage());
                gen.writeEndObject();
            } catch(IOException e1){
                e1.printStackTrace();
            }
        });

        gen.writeEndArray();
    }
}
