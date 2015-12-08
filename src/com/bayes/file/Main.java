package com.bayes.file;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
     public static void main(String args[]) throws IOException{
    	 BayesClassify bcy = new BayesClassify(new String[]{"�ƾ�","����","����","����","����","����","����","�Ļ�","��Ƹ","IT"});
         Scanner sc   = new Scanner(System.in);
         while(sc.hasNextLine())
    	   System.out.println(bcy.classifyText(sc.nextLine()));
     }
}
