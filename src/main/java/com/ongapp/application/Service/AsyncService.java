package com.ongapp.application.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

import com.ongapp.application.Model.Ong;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class AsyncService {


    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Async("asyncExecutor")
    public CompletableFuture<Ong> getOng() throws InterruptedException{
        //System.out.println("Aqui");
        CompletableFuture<Ong> completableFuture 
        = new CompletableFuture<>();
        
        

        Executors.newCachedThreadPool().submit(()->{
            //Thread.sleep(500);    
            //completableFuture.complete(ongData); 
            System.out.println("Entrou Aqui");
            Ong ong = restTemplate.getForObject("http://localhost:3333/ongs", Ong.class);
            System.out.println("Passou Aqui");
            return null;
        });
        System.out.println(3);
        System.out.println(4);
        System.out.println(5);
        

        
        // System.out.println("Passou");
        return completableFuture ;
    }

}