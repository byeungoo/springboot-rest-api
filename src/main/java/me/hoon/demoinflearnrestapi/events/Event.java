package me.hoon.demoinflearnrestapi.events;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@EqualsAndHashCode(of = "id") //entity끼리 상호 참조하는 관계에서, equals와 hash코드를 구현한 코드 안에서 스택오버플로우가 발생할 수 있음. 주로 id만 비교해서 equals와 hash 코드 구현
public class Event {

    private String name;
    private String description;
    private LocalDateTime beginEnrollmentDateTime;
    private LocalDateTime closeEnrollmentDateTime;
    private LocalDateTime beginEventDateTime;
    private LocalDateTime endEventDateTime;
    private String location; // (optional) 이게 없으면 온라인 모임
    private int basePrice; // (optional)
    private int maxPrice; // (optional)
    private int limitOfEnrollment;

    private Integer id;
    private boolean offline;
    private boolean free;
    private EventStatus eventStatus = EventStatus.DRAFT;


}
