package com.api.v1.utils;

import java.util.HashMap;
import java.util.Map;

public class SaleTaxRatesUtil {

    public static double map(String state) {
        Map<String, Double> saleTaxes = new HashMap<>();
        saleTaxes.put("Alabama", 0.04);
        saleTaxes.put("Alaska", 0.0);
        saleTaxes.put("Arizona", 0.056);
        saleTaxes.put("Arkansas", 0.065);
        saleTaxes.put("California", 0.06);
        saleTaxes.put("Colorado", 0.029);
        saleTaxes.put("Connecticut", 0.0635);
        saleTaxes.put("Delaware", 0.0);
        saleTaxes.put("Florida", 0.06);
        saleTaxes.put("Georgia", 0.07);
        saleTaxes.put("Hawaii", 0.04);
        saleTaxes.put("Idaho", 0.06);
        saleTaxes.put("Illinois", 0.0625);
        saleTaxes.put("Indiana", 0.07);
        saleTaxes.put("Iowa", 0.06);
        saleTaxes.put("Kansas", 0.065);
        saleTaxes.put("Kentucky", 0.06);
        saleTaxes.put("Louisiana", 0.0445);
        saleTaxes.put("Maine", 0.055);
        saleTaxes.put("Maryland", 0.06);
        saleTaxes.put("Massachusetts", 0.025);
        saleTaxes.put("Michigan", 0.06);
        saleTaxes.put("Minnesota", 0.06875);
        saleTaxes.put("Mississippi", 0.07);
        saleTaxes.put("Missouri", 0.04225);
        saleTaxes.put("Montana", 0.0);
        saleTaxes.put("Nebraska", 0.065);
        saleTaxes.put("Nevada", 0.0685);
        saleTaxes.put("New Hampshire", 0.0);
        saleTaxes.put("New Jersey", 0.06625);
        saleTaxes.put("New Mexico", 0.0775);
        saleTaxes.put("New York", 0.04);
        saleTaxes.put("North Carolina", 0.0475);
        saleTaxes.put("North Dakota", 0.0675);
        saleTaxes.put("Ohio", 0.0575);
        saleTaxes.put("Oklahoma", 0.045);
        saleTaxes.put("Oregon", 0.0);
        saleTaxes.put("Pennsylvania", 0.06);
        saleTaxes.put("Rhode Island", 0.07);
        saleTaxes.put("South Carolina", 0.06);
        saleTaxes.put("South Dakota", 0.06);
        saleTaxes.put("Tennessee", 0.07);
        saleTaxes.put("Texas", 0.0625);
        saleTaxes.put("Utah", 0.0665);
        saleTaxes.put("Vermont", 0.06);
        saleTaxes.put("Virginia", 0.06);
        saleTaxes.put("Washington", 0.065);
        saleTaxes.put("West Virginia", 0.065);
        saleTaxes.put("Wisconsin", 0.055);
        saleTaxes.put("Wyoming", 0.05);
        return saleTaxes.get(state);
    }

}
