package com.bayes.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Category {
     private Map<String,Integer> count = new HashMap<String,Integer>();
     private String category;
     private int count_num=0;
     private final String PATH_PREFIX = System.getProperty("user.dir")+File.separator+"dataSet"+File.separator+"Sample"
                                                                     +File.separator+"count"+File.separator;
     
     public Category(String category) throws FileNotFoundException{
    	this.category = category;
    	File fl = new File(PATH_PREFIX+category+".txt");
    	Scanner sc = new Scanner(fl);
    	count_num = Integer.parseInt(sc.nextLine());
    	while(sc.hasNextLine()){
    		String[] content = sc.nextLine().split(":");
    		count.put(content[0], new Integer(Integer.parseInt(content[1])));
    	}
     }
     
     public static Category[] getCategorySet(String categories[]) throws FileNotFoundException{
    	 Category[] cg = new Category[categories.length];
    	 for(int i = 0;i<categories.length;i++)
    		 cg[i] = new Category(categories[i]);
    	 return cg;
     }

	public Map<String, Integer> getCount() {
		return count;
	}

	public String getCategory() {
		return category;
	}

	public int getCount_num() {
		return count_num;
	}
}
