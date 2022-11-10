package com.graphqlapibackend.graphql.people.controller;

import com.graphqlapibackend.graphql.people.client.PeopleClient;
import com.graphqlapibackend.graphql.people.dto.PeopleListResponse;
import com.graphqlapibackend.graphql.people.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/peoples")
public class PeopleController {

   @Autowired
   private PeopleService peopleService;

    @GetMapping
    public PeopleListResponse getAllPeople(){
        return peopleService.getAllPeople();
    }

    @GetMapping("name/{name}")
    public PeopleListResponse findPersonByName(@PathVariable String name){
        return peopleService.findPersonByName(name);
    }

    @QueryMapping
    public PeopleListResponse peopleList(){
        return peopleService.getAllPeople();
    }
}
