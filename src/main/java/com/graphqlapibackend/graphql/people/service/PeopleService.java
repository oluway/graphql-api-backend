package com.graphqlapibackend.graphql.people.service;

import com.graphqlapibackend.graphql.people.client.PeopleClient;
import com.graphqlapibackend.graphql.people.dto.PeopleListResponse;
import com.graphqlapibackend.graphql.people.dto.PersonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    public Optional<PeopleListResponse> getAllPeople(int page) {
        return peopleClient.getAllPeople(page);
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

    public Optional<PersonResponse> findPersonByid(int id) {
        try{
            return peopleClient.searchByPersonID(id);
//                    .orElse(PeopleListResponse.createEmptyResult());
        }catch (Exception ex){
            ex.printStackTrace();
//            return PeopleListResponse.createEmptyResult();
        }
        return null;
    }


}
