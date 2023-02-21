package com.example.Playlistservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient

public class PlaylistserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlaylistserviceApplication.class, args);
	}

}
