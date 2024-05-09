package com.example.demoWebClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;

import java.text.MessageFormat;

@SpringBootApplication
public class DemoWebClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoWebClientApplication.class, args);

		String make = "tesla";

		String url = MessageFormat.format("https://vpic.nhtsa.dot.gov/api//vehicles/GetModelsForMake/{0}?format=json", make);

		WebClient.Builder builder = WebClient.builder();

		String vehicle = builder.build()
				.get()
				.uri(url)
				.retrieve()
				.bodyToMono(String.class)
				.block();

		System.out.println("--------------------------------------------------------");
		System.out.println(vehicle);
		System.out.println("--------------------------------------------------------");
	}

}
