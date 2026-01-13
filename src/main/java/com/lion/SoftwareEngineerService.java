package com.lion;

import org.springframework.stereotype.Service;

import java.util.List;

@Service // make class available as a bean. spring makes it available to use within other classes
public class SoftwareEngineerService { //handles business service

    private final SoftwareEngineerRepository softwareEngineerRepository; // label type is an interface (ok)

    public SoftwareEngineerService(SoftwareEngineerRepository softwareEngineerRepository) {
        this.softwareEngineerRepository = softwareEngineerRepository;
    }

    //usually, you do not return the Entity (of type SoftwareEngineer)
    // because it exposes your table, including possible passwords
    // so have a DTO (.stream.map(Class that you want to return to the client))
    public List<SoftwareEngineer> getAllSoftwareEngineers(){
        return softwareEngineerRepository.findAll(); //behind the scene is sql fetching the data
    }

    // not doing any validation..
    public void insertSoftwareEngineer(SoftwareEngineer softwareEngineer) {
        softwareEngineerRepository.save(softwareEngineer);
    }

    public SoftwareEngineer getSoftwareEngineerById(Integer id) {
        return softwareEngineerRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        id + " not found"));
    }
}
