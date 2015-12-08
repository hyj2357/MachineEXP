package com.bayes.file;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
     public static void main(String args[]) throws IOException{
    	 BayesClassify bcy = new BayesClassify(new String[]{"财经","健康","教育","军事","旅游","汽车","体育","文化","招聘","IT"});
         Scanner sc   = new Scanner(System.in);
         while(sc.hasNextLine())
    	   System.out.println(bcy.classifyText(sc.nextLine()));
     }
}
