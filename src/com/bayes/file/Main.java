package com.bayes.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import com.bayes.impl.BayesClassify;

public class Main {
     public static void main(String args[]) throws IOException{
    	 BayesClassify bcy = new BayesClassify(new String[]{"财经","健康","教育","军事","旅游","体育","文化","招聘","IT"});
         boolean exit = false;
         while(!exit){
        	 Scanner sc   = new Scanner(System.in);    	 
             while(sc.hasNextLine()){
               String temp = sc.nextLine();
               exit = temp.equals("@*&exit&*@")?true:false;
               if(exit)
            	   break;
               else{
            	   String f[] = temp.split(":");
                   System.out.println(bcy.classifyText(makeTestDataFileInput(f[0],f[1])));             

               }
        	 }
             sc.close();
         }
     }
     
     public static String makeTestDataFileInput(String dir,String fileName) throws FileNotFoundException{
    	File dt = new File(System.getProperty("user.dir")+File.separator+"testSet"+File.separator+dir+File.separator+fileName+".txt");
 		Scanner sc = new Scanner(dt);
 		String text = "";
 		while(sc.hasNextLine())
 			text += sc.nextLine();
 		return text;
     }
}
