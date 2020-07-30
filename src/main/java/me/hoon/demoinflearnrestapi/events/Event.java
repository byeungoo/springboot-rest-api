package me.hoon.demoinflearnrestapi.events;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@EqualsAndHashCode(of = "id") //entity끼리 상호 참조하는 관계에서, equals와 hash코드를 구현한 코드 안에서 스택오버플로우가 발생할 수 있음. 주로 id만 비교해서 equals와 hash 코드 구현
@Entity
public class Event {

    @Id @GeneratedValue
    private Integer id;
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
    private boolean offline;
    private boolean free;
    @Enumerated(EnumType.STRING)  //기본값 ORDINAL은 순서에 따라서 숫자값 저장. STRING으로 저장하는게 더 안전. 순서 바뀌면 데이터 꼬일 수 있음.
    private EventStatus eventStatus = EventStatus.DRAFT;


    public void update() {
        //Update free
        if (this.basePrice == 0 && this.maxPrice == 0) {
            this.free = true;
        } else {
            this.free = false;
        }

        if(this.location == null || this.location.trim().isEmpty()){
            this.offline = false;
        } else {
            this.offline = true;
        }

    }

}
