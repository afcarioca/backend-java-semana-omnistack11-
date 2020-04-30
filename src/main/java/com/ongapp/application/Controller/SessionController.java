package com.ongapp.application.Controller;

import java.util.HashMap;
import java.util.concurrent.CompletableFuture;

import javax.websocket.RemoteEndpoint.Async;

import com.ongapp.application.Form.AsyncOng;
import com.ongapp.application.Repository.OngRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionController {

    @Autowired
    private OngRepository ongRepository;

    private HttpStatus responseHttp;

    private String chaveHttp;

    @PostMapping("/sessions")
    public HashMap<Object, String> create(@RequestBody HashMap<String, String> id){
        System.out.println(id);

        CompletableFuture<AsyncOng> promisse = importAsyncOng(id);

        HashMap<Object, String> state = new HashMap<>();
        state.put(this.responseHttp, this.chaveHttp);
        return state;
    }

    @org.springframework.scheduling.annotation.Async
    public CompletableFuture<AsyncOng> importAsyncOng(HashMap<String, String> id){
         
        String nameOng = this.ongRepository.findOngByName(id.get("id"));

        if(nameOng == null){
            this.responseHttp = HttpStatus.BAD_REQUEST;
            this.chaveHttp = "No Ong Found with this ID";
            
            return null;
        }
        this.responseHttp = HttpStatus.ACCEPTED;
        this.chaveHttp = nameOng;

        // // AsyncOng asyncOng = new AsyncOng();
        // // asyncOn

        return null;
    }
}