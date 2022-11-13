package com.graphqlapibackend.graphql.people.controller;

import com.graphqlapibackend.graphql.people.dto.PeopleListResponse;
import com.graphqlapibackend.graphql.people.dto.PersonResponse;
import com.graphqlapibackend.graphql.people.service.PeopleService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class PeopleGraphQLController {
    private PeopleService peopleService;

    public PeopleGraphQLController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @QueryMapping
    public PeopleListResponse peopleList(){
        return peopleService.getAllPeople();
    }

    @QueryMapping
    public PeopleListResponse peopleListPaged(@Argument int page){
        return peopleService.getAllPeople(page);
    }

    @QueryMapping
    public PeopleListResponse getPersonByName(@Argument String name){
        return peopleService.findPersonByName(name);
    }

    @QueryMapping
    public Optional<PersonResponse> getPersonByID(@Argument int id){
        return peopleService.findPersonByid(id);
    }
}
