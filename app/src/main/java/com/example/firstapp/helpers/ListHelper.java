package com.example.firstapp.helpers;

import java.util.ArrayList;
import java.util.List;

public class ListHelper {

    public static List<Integer> getIntList(int start, int end){
        List <Integer> list = new ArrayList<>();
        for(int i = start; i <= end; i++){
            list.add(i);
        }
        return list;
    }

    public static List <String> getFamilyNames(){
        List<String> list1 = new ArrayList<>();
        list1.add("Karina");
        list1.add("Andy");
        list1.add("Forbs");

        return list1;
    }



}
