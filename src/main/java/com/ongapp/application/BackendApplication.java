package com.ongapp.application;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class BackendApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	// @Bean("asyncExecutor")
	// public TaskExecutor getAsyncExecutor(){
	// 	ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
	// 	executor.setCorePoolSize(3);
    //     executor.setMaxPoolSize(3);
    //     executor.setQueueCapacity(100);
	// 	executor.setWaitForTasksToCompleteOnShutdown(true);
	// 	executor.setThreadNamePrefix("Async-");

	// 	System.out.println("Entrou Aqui");
	// 	return executor;
	// }

}
