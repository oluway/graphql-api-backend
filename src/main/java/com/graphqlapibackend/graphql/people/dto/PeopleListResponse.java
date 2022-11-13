package com.graphqlapibackend.graphql.people.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PeopleListResponse {
    private String previous;
    private String next;
    private Integer count;
    private List<PersonResponse> results;

    public static PeopleListResponse createEmptyResult(){
        var response = new PeopleListResponse();
        response.setResults(Collections.emptyList());
        return response;
    }
}
