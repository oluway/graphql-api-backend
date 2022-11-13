package com.graphqlapibackend.graphql.people.client;

import com.graphqlapibackend.graphql.people.dto.PeopleListResponse;
import com.graphqlapibackend.graphql.people.dto.PersonResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@FeignClient(
        url = "${services.wapi-api.url}",
        name = "peopleClient",
        contextId = "peopleClientId"
)
public interface PeopleClient {

    @GetMapping
    Optional<PeopleListResponse> getAllPeople();

    @GetMapping
    Optional<PeopleListResponse> getAllPeople(@RequestParam("page") int page);

    @GetMapping
    Optional<PeopleListResponse> searchByPersonName(@RequestParam("search") String name);

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    Optional<PersonResponse> searchByPersonID(@PathVariable("id") int id);


}
