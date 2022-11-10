package com.graphqlapibackend.graphql.people.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonResponse {
    private String name;
    private String height;
    private String mass;
    private String gender;
    private String homeworld;
}
