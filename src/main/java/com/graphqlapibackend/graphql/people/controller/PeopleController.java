package com.graphqlapibackend.graphql.people.controller;

import com.graphqlapibackend.graphql.people.dto.PeopleListResponse;
import com.graphqlapibackend.graphql.people.dto.PersonResponse;
import com.graphqlapibackend.graphql.people.service.PeopleService;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/peoples")
public class PeopleController {

   private PeopleService peopleService;

    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }
    @GetMapping
    public PeopleListResponse getPeople(){
        return peopleService.getAllPeople();
    }

    @GetMapping("name/{name}")
    public PeopleListResponse findPersonByName(@PathVariable String name){
        return peopleService.findPersonByName(name);
    }
    @GetMapping("{id}")
    public Optional<PersonResponse> findPersonByID(@PathVariable int id){
        return peopleService.findPersonByid(id);
    }

}
