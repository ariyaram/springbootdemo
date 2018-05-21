package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@RestController
@EnableAutoConfiguration
@SpringBootApplication
public class DemoApplication {

    @RequestMapping(value="/success", method = RequestMethod.GET)
    public ResponseEntity<String>   testSuccess() {
		System.out.println("testSuccess ***************:");
       return new ResponseEntity<>("Hello World!", HttpStatus.OK);
    }

	 @RequestMapping(value="/hi", method = RequestMethod.GET)
    public ResponseEntity<String>  testError() throws Exception {
	    int i=0;
System.out.println("testError *********************:");
	    Thread.sleep(1200);
	    try{

	    if(i==0){
			System.out.println("22222222222222222222222:");
		    Thread.sleep(1200);
		    throw new Exception("exception raised");
	    }
	    } catch(Exception e){
		    Thread.sleep(1200);
			System.out.println("Exception *****************:");
		    Thread.sleep(1200);
			    e.printStackTrace();
		    }

		     return new ResponseEntity<>("Hello World! Error", HttpStatus.OK);

    }

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
