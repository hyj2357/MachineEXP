package com.bayes.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class TestMain {
    public static void main(String args[]) throws IOException{
   	    //String prefix = System.getProperty("user.dir")+File.separator+"testSet"+File.separator;
        String cl[] = new String[]{"财经","IT","健康","体育","旅游","教育","招聘","文化","军事"};
   	    BayesClassify bcy = new BayesClassify(cl);
   	    String fl[] = {"C000008","C000010","C000013","C000014","C000016","C000020","C000022","C000023","C000024"};
        int right=0,wrong = 0,count=1;
   	    for(int i=0;i<cl.length;i++){
        	for(int j=101;j<=1999;j++){
        		String c = bcy.classifyText(makeTestDataFileInput(fl[i],Integer.toString(j)));
        		int k=0;
        		for(;k<cl.length;k++)
        			if(cl[k].equals(c))
        				break;
        		if(k==i)
        			right++;
        		else
        			wrong++;
        		System.out.println( count+". "+(((double)right)/((double)(right+wrong))*100) +"%");
        		count++;
        	}
        		
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
