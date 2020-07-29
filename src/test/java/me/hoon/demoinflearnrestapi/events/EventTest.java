package me.hoon.demoinflearnrestapi.events;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
class EventTest {

    @Test
    public void builder(){
        Event event = Event.builder()
                .name("Inflearn Spring REST API")
                .description("REST API development with spring")
                .build();
        assertThat(event).isNotNull();
    }

    @Test
    public void javaBean(){
        Event event = new Event();
        String name = "Event";
        String description = "Spring";
        event.setName(name);
        event.setDescription("Spring");

        assertThat(event.getName()).isEqualTo(name);
        assertThat(event.getDescription()).isEqualTo(description);
    }

    @Test
    public void testFree(){

        Event event = Event.builder()
                .basePrice(0)
                .maxPrice(0)
                .build();

        //When
        event.update();

        //Then
        assertThat(event.isFree()).isTrue();

        event = Event.builder()
                .basePrice(100)
                .maxPrice(0)
                .build();

        //When
        event.update();

        //Then
        assertThat(event.isFree()).isFalse();
    }

    @Test
    public void testOffline(){
        Event event = Event.builder()
                .location("강남역 네이버 D2 스타텁 팩토리")
                .build();

        //When
        event.update();

        //Then
        assertThat(event.isOffline()).isTrue();

        event = Event.builder()
                .build();

        //When
        event.update();

        //Then
        assertThat(event.isOffline()).isFalse();
    }

}