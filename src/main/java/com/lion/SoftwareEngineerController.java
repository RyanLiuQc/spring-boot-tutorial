package com.lion;

import java.util.List;

import org.springframework.web.bind.annotation.*;

// in spring boot, anything that accepts requests from client or exposes rest api or endpoints are conventionally named controller
@RestController
@RequestMapping("api/v1/software-engineers")
public class SoftwareEngineerController {

    private final SoftwareEngineerService softwareEngineerService;

    public SoftwareEngineerController(SoftwareEngineerService softwareEngineerService) {
        this.softwareEngineerService = softwareEngineerService;
    }

    @GetMapping
    public List<SoftwareEngineer> getEngineers(){
        return softwareEngineerService.getAllSoftwareEngineers();
    }

    @GetMapping("{id}")
    public SoftwareEngineer getEngineersById(@PathVariable Integer id){
        return softwareEngineerService.getSoftwareEngineerById(id);
    }

    // define endpoint to add new software engineers to the database
    @PostMapping
    public void addNewSoftwareEngineer(
            // @RequestBody to map json into a java class
            @RequestBody SoftwareEngineer softwareEngineer){ //usually not recommanded to use entity directly
        softwareEngineerService.insertSoftwareEngineer(softwareEngineer);
    }
}
