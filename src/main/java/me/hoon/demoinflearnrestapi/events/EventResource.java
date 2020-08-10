package me.hoon.demoinflearnrestapi.events;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.EntityModel;

@AllArgsConstructor
public class EventResource extends EntityModel<Event> {

    @JsonUnwrapped
    private Event event;

    /*
    public EventResource(Event event, Link... links){
        super();
        add(linkTo(EventController.class).slash(event.getId()).withSelfRel());
    }
    */

}