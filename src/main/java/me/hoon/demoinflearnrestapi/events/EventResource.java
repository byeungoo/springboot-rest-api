package me.hoon.demoinflearnrestapi.events;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

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