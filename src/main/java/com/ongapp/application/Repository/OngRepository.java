package com.ongapp.application.Repository;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.ongapp.application.Model.Ong;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.scheduling.annotation.Async;


public interface OngRepository extends JpaRepository<Ong, String> {
    
    @Override
    public  <S extends Ong> S save(S entity);

    @Query("SELECT name FROM Ong WHERE id = ?1")
    String findOngByName(String id);
      
    
}