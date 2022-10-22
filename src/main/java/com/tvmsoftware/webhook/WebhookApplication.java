package com.tvmsoftware.webhook;

import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
@Log
public class WebhookApplication {

	public static void main(String[] args) {

		SpringApplication.run(WebhookApplication.class, args);
	}

	@PostConstruct
	public void startupApplication() {
		log.info("FAI_WEBHOOK_USER:"+System.getenv("FAI_WEBHOOK_USER"));
	}

}
