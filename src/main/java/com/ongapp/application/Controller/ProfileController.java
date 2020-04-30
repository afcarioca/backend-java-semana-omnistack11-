package com.ongapp.application.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.ongapp.application.Form.AsyncIncident;
import com.ongapp.application.Model.Incident;
import com.ongapp.application.Model.Ong;
import com.ongapp.application.Repository.IncidentRepository;
import com.ongapp.application.Repository.OngRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {


    @Autowired
    private IncidentRepository incidentRepository;

    @Autowired
    private OngRepository ongRepository;

    private List<Incident> incidents = new ArrayList<>();

    @GetMapping("/profile")
    public List<Incident> index(@RequestHeader("authorization")String ongId) throws InterruptedException {
        System.out.println(ongId);
        CompletableFuture<AsyncIncident> promisse = importAsyncIncident(ongId);
        Thread.sleep(1000l);
        
        return this.incidents;
    } 

    @Async
    public CompletableFuture<AsyncIncident> importAsyncIncident(String ongId){
        // Ong ong = new Ong();
        // Incident incidente = new Incident();

        // incidente.setOngId(ongRepository.getOne(ongId));
        // System.out.println(ong.getName());
        
        List<Incident> findAll = this.incidentRepository.findAll();
        Incident incidente = new Incident();
        for (Incident incident : findAll) {
            if(incident.getOngId().getId().equals(ongId)){
                incidente = incident;
                break;
            }

        }

        this.incidents = this.incidentRepository.findByOngId(incidente.getOngId());      
        
        AsyncIncident asyncIncident = new AsyncIncident();
        asyncIncident.setIncidents(incidents);
        
        return CompletableFuture.completedFuture(asyncIncident);
    }
}