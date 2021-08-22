package com.store.beautyproducts.resources.utils;

import java.net.URLDecoder;
import java.util.*;



public class URL {
    public static String decodeParam(String s){
        try {
            return URLDecoder.decode(s, "UTF-8");
        } catch (Exception e) {
            return "";
        }
    }
    public static List<Integer> decodeIntList(String s){
        String[] vet = s.split(",");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < vet.length; i++){
            list.add(Integer.parseInt(vet[i]));
        }
        return list;
      //  return Arrays.asList(s.split(",")).stream().map(x -> Integer.parseInt(x)).collect(Collectors.toList());
    }
    
}
