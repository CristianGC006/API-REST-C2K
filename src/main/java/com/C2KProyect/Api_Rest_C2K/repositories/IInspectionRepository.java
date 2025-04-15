package com.C2KProyect.Api_Rest_C2K.repositories;


import com.C2KProyect.Api_Rest_C2K.models.Inspection;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInspectionRepository extends JpaRepository<Inspection, Integer> {
}
