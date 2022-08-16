package com.careerdevs.nasaapod.models;

import com.fasterxml.jackson.annotation.JsonInclude;

public class NasaModel {

    private String title;
    private String date;
    private String explanation;
    private String url;


    @JsonInclude(JsonInclude.Include.NON_DEFAULT)

    private String copyright;

    @JsonInclude(JsonInclude.Include.NON_NULL)

    private String hdurl;
    private String media_type;
    private String service_version;


    public String getExplanation() {
        return explanation;
    }

    public String getTitle() {
        return title;
    }

    public String getCopyright() {
        return copyright;
    }

    public String getDate() {
        return date;
    }

    public String getUrl() {
        return url;
    }

    public String getHdurl() {
        return hdurl;
    }

    public String getMedia_type() {
        return media_type;
    }

    public String getService_version() {
        return service_version;
    }
}