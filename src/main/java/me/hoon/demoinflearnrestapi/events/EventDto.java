package me.hoon.demoinflearnrestapi.events;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EventDto {

    @NotEmpty @NotBlank
    private String name;
    @NotEmpty @NotBlank
    private String description;
    @NotNull @NotBlank
    private LocalDateTime beginEnrollmentDateTime;
    @NotNull @NotBlank
    private LocalDateTime closeEnrollmentDateTime;
    @NotNull @NotBlank
    private LocalDateTime beginEventDateTime;
    @NotNull @NotBlank
    private LocalDateTime endEventDateTime;
    private String location; // (optional) 이게 없으면 온라인 모임
    @Min(0)
    private int basePrice; // (optional)
    @Min(0)
    private int maxPrice; // (optional)
    @Min(0)
    private int limitOfEnrollment;

}
