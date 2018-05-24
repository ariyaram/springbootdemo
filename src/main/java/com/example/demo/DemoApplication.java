package com.example.demo;

import org.apache.log4j.Logger;
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

    Logger logger = Logger.getLogger(DemoApplication.class);

    @RequestMapping(value = "/success", method = RequestMethod.GET)
    public ResponseEntity<String> testSuccess() {
        System.out.println("testSuccess ***************:");
        return new ResponseEntity<>("Hello World!", HttpStatus.OK);
    }

    @RequestMapping(value = "/errorcall", method = RequestMethod.GET)
    public ResponseEntity<String> testError() throws Exception {
        int i = 0;
        logger.error("1st testError  Method *********************:");
        Thread.sleep(3000);
        try {

            if (i == 0) {
                logger.error("2nd calling in try method ");
                Thread.sleep(3000);
                throw new Exception("4th exception raised");
            }
        } catch (Exception e) {
            Thread.sleep(3000);
            logger.error("3rd Exception *****************:");
            Thread.sleep(3000);
            e.printStackTrace();
        }

        return new ResponseEntity<>("Hello World! Error", HttpStatus.OK);

    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
