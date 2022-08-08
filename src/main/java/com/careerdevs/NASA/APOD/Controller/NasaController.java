package com.careerdevs.NASA.APOD.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

//added date route
@RestController
    public class NasaController {
        private String myNasaKey = "B56HiyvCcnfXdtnIilPgqsJBgKw7VIaJKLzxHvNG";
        private String nasaApodEndpoint = "https://api.nasa.gov/planetary/apod?api_key=" + myNasaKey;
        private String date = "2014-10-01";
    private String dateEndPoint = nasaApodEndpoint + "&date=" + date;


    @GetMapping("/")
        private String routeRoute() {
            return "Your requested root";
        }

        @GetMapping("/apod")
        public Object apodRoute(RestTemplate restTemplate) {
            return restTemplate.getForObject(nasaApodEndpoint, Object.class);
        }
    @GetMapping("/date")
    public Object dateRoute(RestTemplate restTemplate) {
        return restTemplate.getForObject(dateEndPoint, Object.class);
    }

//    public String getDateEndPoint() {
//        return restTemplate.getForObject(dateEndPoint, Object.class);
//
//        return dateEndPoint;
//    }
}
