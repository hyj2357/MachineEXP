package com.bayes.file;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.bayes.impl.Category;

import test.Spliter;

public class BayesClassify {
	 private Category[] categories;
	 
     public BayesClassify(String categories[]) throws FileNotFoundException{
    	 this.categories = Category.getCategorySet(categories);
     }
     
     public String classifyText(String text) throws IOException{
    	 String a[] = Spliter.splitText(text);
    	 double p[] = new double[categories.length];
    	 int cc[] = new int[this.categories.length];
    	 for(int i=0;i<this.categories.length;i++){
    		 int LaplaceCalibration = 0;
    		 for(int j=0;j<a.length;j++){
    			 
    		 }
    	 }
    	 return null;
     }
     
     private int MP(double lf){
    	 int c = 0;
    	 while(lf>=1){
    		 lf*=10;
    		 c++;
    	 }
    	 return c;	 
     }
}
