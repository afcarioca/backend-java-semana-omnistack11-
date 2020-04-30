package com.ongapp.application.Controller;

 
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import com.ongapp.application.Model.Ong;

import com.ongapp.application.Service.AsyncService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
 

@RestController
public class AsyncController {
 
 
    @Autowired
    private AsyncService service;
 
    @GetMapping("/testAsynch")
    public void testAsynch() throws InterruptedException, ExecutionException 
    {   
        System.out.println("1");
        System.out.println("111");
        System.out.println("1111");
        
        Thread.sleep(100L);
        CompletableFuture<Ong> ong = service.getOng();
        
        System.out.println("Passou Aqui também");

        System.out.println("1");
        System.out.println("111");
        System.out.println("1111");
        System.out.println("1");
        System.out.println("111");
        System.out.println("1111");
        System.out.println("1");
        System.out.println("111");
        System.out.println("1111");
        System.out.println(ong);



        // System.out.println(service.getOng());
 
        // System.out.println("Entou Aqui");
        // System.out.println(CompletableFuture.completedFuture(ong));

         
        // System.out.println(ong.get());
    }
}