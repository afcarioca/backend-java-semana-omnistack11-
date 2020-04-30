package com.ongapp.application.Form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import com.ongapp.application.Model.Ong;
import com.ongapp.application.Repository.OngRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;

public class AsyncOng {
        
    private StringBuilder log = new StringBuilder();
    private List<Ong> ongs = new ArrayList<>();
    private String id;
    private Ong s;
        

     public AsyncOng() {
        
        // this.asyncOng = new AsyncOng();
     }
        

    public String getId(){
            return this.id;
    }
    
    public AsyncOng(StringBuilder log) {
            this.log = log;
    }


    public void setOng(Ong ong){
        this.s = ong;
    }

    public void addLog(String s){
            this.log.append(s).append("<br>");
    }


    public void setOngs(List<Ong> ongs) {
            this.ongs = ongs;
    }

    public String getLog() {
            return log.toString();
    }

    public List<Ong> getOngs() {
            return ongs;
    }

//     @Async
//     public CompletableFuture<AsyncOng> importAsyncOng( HashMap<String, String> body) {
//         String stringId = UUID.randomUUID().toString();
//         this.id = stringId.substring(0, 8);
        
//         Ong ong  = new Ong();
//             ong.setId(this.id);
//             ong.setName(body.get("name"));
//             ong.setEmail(body.get("email"));
//             ong.setWhatsapp(body.get("whatsapp"));
//             ong.setCity(body.get("city"));
//             ong.setUf(body.get("uf"));
        
//             this.ongRepository.save(ong);
            
//             AsyncOng form = new AsyncOng();
             
//             form.setOng(ong);
            
//             return CompletableFuture.completedFuture(form);
//     }

    
}