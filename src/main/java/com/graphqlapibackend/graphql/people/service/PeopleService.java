package com.graphqlapibackend.graphql.people.service;

import com.graphqlapibackend.graphql.people.client.PeopleClient;
import com.graphqlapibackend.graphql.people.dto.PeopleListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeopleService {
    @Autowired
    private PeopleClient peopleClient;

    public PeopleListResponse getAllPeople() {
        try {
            return peopleClient.getAllPeople()
                    .orElse(PeopleListResponse.createEmptyResult());
        }catch (Exception ex){
            ex.printStackTrace();
            return PeopleListResponse.createEmptyResult();
        }
    }

    public PeopleListResponse findPersonByName(String name) {
        try{
            return peopleClient.searchByPersonName(name)
                    .orElse(PeopleListResponse.createEmptyResult());
        }catch (Exception ex){
            ex.printStackTrace();
            return PeopleListResponse.createEmptyResult();
        }
    }
}
