package com.graphqlapibackend.graphql.people.client;

import com.graphqlapibackend.graphql.people.dto.PeopleListResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    Optional<PeopleListResponse> searchByPersonName(@RequestParam("search") String personName);
}
