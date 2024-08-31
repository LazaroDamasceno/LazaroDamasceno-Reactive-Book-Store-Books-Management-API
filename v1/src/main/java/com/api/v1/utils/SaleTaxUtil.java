package com.api.v1.utils;

import java.util.HashMap;
import java.util.Map;

public class SaleTaxUtil {

    public static Map<String, Double> map(String state) {
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
        return null;
    }

}
