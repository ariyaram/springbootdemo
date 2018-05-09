package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@SpringBootApplication
public class DemoApplication {

    @RequestMapping("/success")
    String home() {
        return "Hello World!";
    }
	
	 @RequestMapping("/error")
    String home1() {
	    int i=0;
	    
	    try{
		    
	    if(i==0){
		    throw new Exception();
	    }
	    } catch(Exception e){
			    e.printStackTrace();
		    }
        return "Hello World!";
    }
    
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
