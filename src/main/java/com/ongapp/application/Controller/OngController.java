package com.ongapp.application.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import com.ongapp.application.Form.AsyncOng;
import com.ongapp.application.Model.Ong;
import com.ongapp.application.Repository.OngRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class OngController {

    @Autowired
    private OngRepository ongRepository;
    private List<Ong> ongs = new ArrayList<>();
    // private UUID id;
    private String id;    


    @GetMapping("/ongs")
    public List<Ong> index() throws InterruptedException {

        CompletableFuture<AsyncOng> promisse = importAsyncOngs();
        Thread.sleep(1000L);
        System.out.println(promisse);
        System.out.println("------");
        System.out.println(this.ongs);
        return this.ongs;
    }

    @Async
    public CompletableFuture<AsyncOng> importAsyncOngs() {
        this.ongs = this.ongRepository.findAll();
        AsyncOng ong = new AsyncOng();
        ong.setOngs(this.ongs);
        
        return CompletableFuture.completedFuture(ong);
        
    }


    // @Async
    // @GetMapping("/v")
    // public void asyncMethodWithVoidReturnType() {
    //     System.out.println("Execute method asynchronously. "
    //     + Thread.currentThread().getName());
    // }

//     @Async
//     public Future<String> asyncMethodWithReturnType() {
//         System.out.println("Execute method asynchronously - "
//         + Thread.currentThread().getName());
//         try {
//             Thread.sleep(5000);
//             return new AsyncResult<String>("hello world !!!!");
//     } catch (final InterruptedException e) {
//         //
//     }
 
//     return null;
//  }

//  @GetMapping(path = "/testingAsync")
// public DeferredResult<String> value() throws ExecutionException, InterruptedException, TimeoutException {
//     final AsyncRestTemplate restTemplate = new AsyncRestTemplate();
//     final String baseUrl = "https://localhost:3333/ongs";
//     final HttpHeaders requestHeaders = new HttpHeaders();
//     requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//     final String value = "";

//     final HttpEntity entity = new HttpEntity("parameters", requestHeaders);
//     final DeferredResult<String> result = new DeferredResult<>();
//     final ListenableFuture<ResponseEntity<Ong>> futureEntity = restTemplate.getForEntity(baseUrl, Ong.class);

//     futureEntity.addCallback(new ListenableFutureCallback<ResponseEntity<Ong>>() {
//         @Override
//         public void onSuccess(ResponseEntity<Ong> result) {
//             System.out.println(result.getBody().getName());
//             // result.setResult(result.getBody().getName());
//         }

//         @Override
//         public void onFailure(final Throwable ex) {
//             result.setErrorResult(ex.getMessage());
//         }
//     });

//     return result;
// }


// @GetMapping("/")
// public void testAsyncAnnotationForMethodsWithReturnType()
//   throws InterruptedException, ExecutionException {
//     System.out.println("Invoking an asynchronous method. "
//       + Thread.currentThread().getName());
//     final Future<String> future = asyncMethodWithReturnType();
 
//     while (true) {
//         if (future.isDone()) {
//             System.out.println("Result from asynchronous process - " + future.get());
//             break;
//         }
//         System.out.println("Continue doing something else. ");
//         Thread.sleep(1000);
//     }
// }

    // private static void findAllOngs(){
    //     doAThing()
    //         .thenCompose(OngController::doAnotherThing)
    //         .thenAccept(OngController::reportSuccess)
    //         .exceptionally(OngController::reportFailure);
    // }



    @PostMapping("/ongs")
    public HashMap<String, String> create(@RequestBody HashMap<String, String> body) throws InterruptedException {
        
        CompletableFuture<AsyncOng> promisse = importAsyncOng(body);
        Thread.sleep(1000L);
        System.out.println(promisse);   
        System.out.println("------");
        System.out.println(body);
        
        // HashMap<String, UUID> id = new HashMap<String, UUID>();
        HashMap<String, String> id = new HashMap<>();
        
        id.put("id", this.id);

        return id;
    }

    @Async
    public CompletableFuture<AsyncOng> importAsyncOng( HashMap<String, String> body) {
        
        // this.id = UUID.randomUUID();
        this.id = UUID.randomUUID().toString();
        this.id = this.id.substring(0,8);
        Ong ong  = new Ong();
        ong.setId(this.id);
        ong.setName(body.get("name"));
        ong.setEmail(body.get("email"));
        ong.setWhatsapp(body.get("whatsapp"));
        ong.setCity(body.get("city"));
        ong.setUf(body.get("uf"));
    
        this.ongRepository.save(ong);

        AsyncOng form = new AsyncOng();
        form.setOng(ong);
        return CompletableFuture.completedFuture(form);
    }

    
}