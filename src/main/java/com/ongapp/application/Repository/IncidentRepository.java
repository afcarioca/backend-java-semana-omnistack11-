package com.ongapp.application.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.ongapp.application.Model.Incident;
import com.ongapp.application.Model.Ong;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IncidentRepository extends JpaRepository<Incident, Long> {
    
    @Query("SELECT i FROM Incident i WHERE i.ongId = ?1 ")
     List<Incident> findIncidentByOngId(Ong ongId);
    //  Page<Incident> findById(long id, PageRequest pageRequest);
    
    // @Query("SELECT i, o.name FROM Incident i LEFT JOIN Ong o ON i.ongId = :incidents.ongId" )
    
    // @Query("SELECT i, o FROM Incident i LEFT JOIN Ong o ON i.ongId = o.id WHERE i.id = ?1" )
    //  Object[]  AllIncident(Long id);
    
    // Page<Incident> findAll(PageRequest pageRequest);

    List<Incident> findByTitle(String title);
    List<Incident> findByOngId(Ong ongId);
}