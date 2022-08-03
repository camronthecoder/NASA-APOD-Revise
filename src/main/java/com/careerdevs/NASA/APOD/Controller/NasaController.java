package com.careerdevs.NASA.APOD.Controller;


//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
////https://apod.nasa.gov/apod/ap220802.html
//@RestController
//@RequestMapping("/nasa")

//public class NasaController {

//    private String myNasaKey = "B56HiyvCcnfXdtnIilPgqsJBgKw7VIaJKLzxHvNG";
//    private String nasaApodEndpoint = "https://api.nasa.gov/planetary/apod?api_key=" + myNasaKey;
//

//    }
//    @GetMapping("/")
//    private String routeRoute (){
//        return "Your requested root";
//    }
//
//    }

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

    @RestController
    public class NasaController {
        private String myNasaKey = "B56HiyvCcnfXdtnIilPgqsJBgKw7VIaJKLzxHvNG";
        private String nasaApodEndpoint = "https://api.nasa.gov/planetary/apod?api_key=" + myNasaKey;

        @GetMapping("/")
        private String routeRoute (){
            return "Your requested root";
        }

            @GetMapping("/apod")
    public Object apodRoute (RestTemplate restTemplate) {
            return restTemplate.getForObject(nasaApodEndpoint, Object.class);
            }}
//


