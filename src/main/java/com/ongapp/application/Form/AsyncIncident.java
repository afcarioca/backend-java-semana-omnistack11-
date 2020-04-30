package com.ongapp.application.Form;

import java.util.ArrayList;
import java.util.List;

import com.ongapp.application.Model.Incident;

public class AsyncIncident {

    private List<Incident> incidents = new ArrayList<>(); 
    private String id;
    private Incident incident;

    public AsyncIncident(){

    }

    public String getId(){
        return this.id;
}

   


    public void setIncident(Incident incident){
        this.incident = incident;
    }

    // public void addLog(String s){
    //         this.log.append(s).append("<br>");
    // }


    public void setIncidents(List<Incident> incidents) {
            this.incidents = incidents;
    }

    // public String getLog() {
    //         return log.toString();
    // }

    public List<Incident> getIncidents() {
            return this.incidents;
    }
}