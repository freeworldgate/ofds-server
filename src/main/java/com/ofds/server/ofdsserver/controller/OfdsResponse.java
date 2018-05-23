package com.ofds.server.ofdsserver.controller;

import java.util.HashMap;
import java.util.Map;

public class OfdsResponse {

    private Map<String,HashMap<String,String>> singleFeatures =  new HashMap<String,HashMap<String,String>>();


    public OfdsResponse(Map<String, HashMap<String, String>> singleFeatures) {
        this.singleFeatures = singleFeatures;
    }


    public Map<String, HashMap<String, String>> getSingleFeatures() {
        return singleFeatures;
    }

    public void setSingleFeatures(Map<String, HashMap<String, String>> singleFeatures) {
        this.singleFeatures = singleFeatures;
    }

}
