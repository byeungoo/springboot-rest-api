package me.hoon.demoinflearnrestapi.events;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.hoon.demoinflearnrestapi.common.RestDocsConfiguration;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureRestDocs
@Import(RestDocsConfiguration.class) //RestDocsConfiguration 적용
@ActiveProfiles("test")
@Ignore //테스트를 실행하는 컨트롤러가 아님
public class BaseControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    ModelMapper modelMapper;

}
