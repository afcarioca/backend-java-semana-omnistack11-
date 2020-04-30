package com.ongapp.application.Controller;

import org.springframework.web.bind.annotation.RestController;

import net.bytebuddy.asm.Advice.AllArguments;
import net.bytebuddy.asm.Advice.OnDefaultValue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.x.protobuf.MysqlxCrud.Order;
import com.ongapp.application.Form.AsyncIncident;
import com.ongapp.application.Model.Incident;
import com.ongapp.application.Model.Ong;
import com.ongapp.application.Repository.IncidentRepository;
import com.ongapp.application.Repository.OngRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Async;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;


@RestController
public class IncidentController {

    @Autowired
    private IncidentRepository incidentRepository;
  
    @Autowired
    private OngRepository ongRepository;    

    private Incident incident;

    private List<Incident> incidents = new ArrayList<>();
    // private Page<Incident> pages;
    private HttpStatus httpStatus;

    private String page;

    private Long contador; 

    private String responseHttP;

    @GetMapping("/incidents")
    
    public List<Incident> index(@RequestParam  Map<String, String> page, HttpServletResponse response) throws InterruptedException {
        this.page = page.get("page");

        System.out.println(this.page);

        int parseInt = Integer.parseInt(this.page);

        CompletableFuture<AsyncIncident> promisse = importAsyncIncident(parseInt);
        Thread.sleep(1000L);
        System.out.println(promisse);
        System.out.println("------");
        
        response.setHeader("X-Total-Count", this.contador.toString());

        return this.incidents;

        // return null;

    }

    @Async
    public CompletableFuture<AsyncIncident> importAsyncIncident(int page) {
        //  PageRequest pageRequest = PageRequest.of(0, 5);

        // Page<Incident> findById = this.incidentRepository.findById(1l, pageRequest);
        // System.out.println(findById);

        PageRequest of = PageRequest.of(page - 1, 5);
        
        
        Page<Incident> incidents = this.incidentRepository.findAll(of);
        this.incidents = incidents.getContent();
        
        

        this.contador = this.incidentRepository.count();

        for (Incident incident : incidents) {
            System.out.println(incident.getOngId());
            //  System.out.println(this.incidentRepository.findByOngId(incident.getOngId()));   
        }

        //  List<Incident> outros = new ArrayList<>(); 
        //  Iterable<Map<String, Object>> algoIterable;
        //  List<Object[]> objetos = new ArrayList<>();   
        //  for (Incident incident : incidents) {
        //       Object[] allIncident = this.incidentRepository.AllIncident(incident.getId()); 
        //       objetos.add(allIncident);
        //     //   System.out.println(allIncident);  
        //     }

        //     for (Object[] objects : objetos) {
        //         Incident i =(Incident)objects[0];
        //         System.out.println(i.getId());
        //         // System.out.println(objects[0]);
        //         System.out.println(objects[1]);
        //     }

        
        // while (algoIterable.hasNext()) {
        //     Map<String, Object> map = it.next();
        //     obj = neo4jOperations.convert(map.get("member"), Node.class);
        //     ...
        //  }

        // outros = this.incidents;

        //    List<String> allIncident = this.incidentRepository.AllIncident();

        //    for (Object object : allIncident) {
        //        System.out.println(object);
        //    }
            // List<Object> allIncident = this.incidentRepository.AllIncident();
           
        // List<Incident> findAllIncident = this.incidentRepository.findAllIncident(this.incidents);
        // for (Incident incident : this.incidents) {
        //     System.out.println(incident.getOngId());
        // }
        // this.incidents = findAllIncident;

        // System.out.println(findAll.getSize());

        // for (Incident incident : findAll) {
        //     System.out.println(incident.getTitle());
        // }
            
        // System.out.println("Entrou");
        // System.out.println(page);
        //this.incidents = this.incidentRepository.findAll();
        //    this.incidents = this.incidentRepository.findAll(of); 
        // this.incidents = this.incidentRepository.findAll();
        
        // this.pages = incidents;
        System.out.println(this.incidentRepository.findByTitle("Caso 1"));
        
        AsyncIncident asyncIncident = new AsyncIncident();
        asyncIncident.setIncidents(this.incidents);

        return CompletableFuture.completedFuture(asyncIncident);

        // return null;
    }

    @PostMapping("/incidents")
    public HashMap<String, Long> create(@RequestBody HashMap<String, Object> body,
            @RequestHeader("authorization") String ongId) throws InterruptedException {

        // System.out.println(ongId);
        // System.out.println(body);
        CompletableFuture<AsyncIncident> promisse = importAsyncIncident(body, ongId);
        Thread.sleep(1000L);

        HashMap<String, Long> id = new HashMap<>();
        id.put("id", this.incident.getId());
        // this.incidentRepository.set

        return id;

    }

    @Async
    public CompletableFuture<AsyncIncident> importAsyncIncident(HashMap<String, Object> body,
            String ongId) {
        this.incident = new Incident();
        System.out.println(this.ongRepository.getOne(ongId));
        // // System.out.println(ongId.getClass());
        // List<Ong> ongs = this.ongRepository.findAll();
        // Ong ong1 = new Ong();

        // for (Ong ong : ongs) {
        // if(ong.getId().equals(ongId)){
        // ong1 = ong;
        // System.out.println("Entrou");
        // break;
        // }

        // }

        // // System.out.println(body.get("value"));
        incident.setTitle(body.get("title"));
        incident.setDescription(body.get("description"));
        incident.setValue((double) body.get("value"));
        incident.setOngId(this.ongRepository.getOne(ongId));

        // // System.out.println(incident.getOngId().getId());
        // // System.out.println(this.ongRepository.getOne(ongId));
        this.incidentRepository.save(incident);

        AsyncIncident asyncIncident = new AsyncIncident();
        asyncIncident.setIncident(incident);

        return CompletableFuture.completedFuture(asyncIncident);

    }

    @DeleteMapping("/incidents/{id}")
    @ResponseStatus(code = HttpStatus.CREATED)
    public HashMap<HttpStatus, String> delete(@PathVariable final Long id,
            @RequestHeader("authorization") final String ongId) throws InterruptedException {
        System.out.println(id);
        System.out.println(ongId);
        // String reasonPhrase = HttpStatus.ACCEPTED.getReasonPhrase();

        CompletableFuture<AsyncIncident> promisse = importAsyncIncident(id, ongId);
        Thread.sleep(1000L);
        
        HashMap<HttpStatus, String> status = new HashMap<>();

        status.put(this.httpStatus, this.responseHttP);

        return status;
    }

    @Async
    public CompletableFuture<AsyncIncident> importAsyncIncident(Long id,  String ongId) {
        // Incident findIncidentById = this.incidentRepository.findIncidentById(id);
        Incident incident = this.incidentRepository.getOne(id);
        // System.out.println(incident.getOngId());

        if (!incident.getOngId().getId().equals(ongId)) {
            this.httpStatus = HttpStatus.UNAUTHORIZED;
            this.responseHttP = "Operation not permitted";
            return null;
        }

        this.incidentRepository.deleteById(id);

        this.httpStatus = HttpStatus.ACCEPTED;
        this.responseHttP = "Success!";
        System.out.println("Passou por aqui");

        AsyncIncident asyncIncident = new AsyncIncident();
        asyncIncident.setIncident(incident);

        return CompletableFuture.completedFuture(asyncIncident);
    }
    
}