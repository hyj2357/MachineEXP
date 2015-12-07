package com.bayes.impl;

import java.util.HashMap;
import java.util.Map;

public class Category {
     private Map<String,Integer> count = new HashMap<String,Integer>();
     private String category;
     private int count_num=0,LaplaceCalibration=0;
     private final String pathPrefix = System.getProperty("user.dir")+"//"
     
     public Category(String category){
    	 
     }
     
     public static Category[] getCategorySet(String categories[]){
    	 Category[] cg = new Category[categories.length];
    	 for(int i = 0;i<categories.length;i++)
    		 cg[i] = new Category(categories[i]);
    	 return cg;
     }
}
