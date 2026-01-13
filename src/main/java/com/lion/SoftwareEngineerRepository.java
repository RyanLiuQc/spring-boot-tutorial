package com.lion;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SoftwareEngineerRepository
        extends JpaRepository<SoftwareEngineer, Integer> { // generic is the entity and the data type of the key (id)


}
