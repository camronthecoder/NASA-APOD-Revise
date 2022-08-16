package com.careerdevs.nasaapod.controllers;

import com.careerdevs.nasaapod.models.NasaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

//by adding the RequestMapping annotation to this class,
// all the route handler implemented in this class will have /nasa added to their endpoint
// (the URL you need to request to get the method to run):

@RestController
@RequestMapping("/nasa")
public class NasaController {
    @Autowired
    private Environment env;
    private final String nasaApodEndpoint = "https://api.nasa.gov/planetary/apod?api_key=";


//These fields are made final therefore they're immutable (unable to be changed).


    @GetMapping("/apod")
    ResponseEntity<?> apodToday(RestTemplate restTemplate) {
        try {

            String key = env.getProperty("APOD_KEY", "DEMO_KEY");
            final String url = nasaApodEndpoint + key;
            NasaModel response = restTemplate.getForObject(url, NasaModel.class);
            return ResponseEntity.ok(response);
        } catch (HttpClientErrorException.Forbidden e) {
            return ResponseEntity.status(500).body("Server has no API key or it is invalid");
        } catch (Exception e) {
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().body(e.getMessage());

        }
    }

    @GetMapping("/bydate/{date}")
    ResponseEntity<?> apodByDatePathVariable(RestTemplate restTemplate, @PathVariable String date) {
        try {
            String key = env.getProperty("APOD_KEY");
            if (key == null) {
                return ResponseEntity.internalServerError().body("Api key is not present");
            }

            String url = nasaApodEndpoint + key + "&date=" + date;
            NasaModel response = restTemplate.getForObject(url, NasaModel.class);
            return ResponseEntity.ok(response);

    }catch(
    HttpClientErrorException.Forbidden e)

    {
        return ResponseEntity.status(500).body("Server has no API key or it is invalid");
    } catch(HttpClientErrorException.BadRequest e) {
        return ResponseEntity.badRequest().body("Invalid date:" + date);


    } catch(
    Exception e)

    {
        System.out.println(e.getClass());
        System.out.println(e.getMessage());
        return ResponseEntity.internalServerError().body(e.getMessage());

    }

}}