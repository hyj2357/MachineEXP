package com.bayes.file;

import java.io.File;
import java.io.IOException;

public class FileMain {
    public static void main(String args[]) throws IOException{
    	ProcessSample ps = new ProcessSample();
    	String dataPath[] = {"C000007/10.txt","C000007/11.txt","C000007/12.txt","C000007/13.txt","C000007/14.txt","C000007/15.txt","C000007/16.txt","C000007/17.txt","C000007/18.txt","C000007/19.txt"};
    	String category = "汽车";
    	ps.processTrainSet(dataPath, category);

    	dataPath = makeDataFilePaths("C000008","txt",10,100);
    	category = "财经";
    	ps.processTrainSet(dataPath, category);
    	
    	dataPath = makeDataFilePaths("C000010","txt",10,100);
    	category = "IT";
    	ps.processTrainSet(dataPath, category);
    	
    	dataPath = makeDataFilePaths("C000013","txt",10,100);
    	category = "健康";
    	ps.processTrainSet(dataPath, category);
    	
    	dataPath = makeDataFilePaths("C000014","txt",10,100);
    	category = "体育";
    	ps.processTrainSet(dataPath, category);
    	
    	dataPath = makeDataFilePaths("C000016","txt",10,100);
    	category = "旅游";
    	ps.processTrainSet(dataPath, category);
    	
    	dataPath = makeDataFilePaths("C000020","txt",10,100);
    	category = "教育";
    	ps.processTrainSet(dataPath, category);
    	
    	dataPath = makeDataFilePaths("C000022","txt",10,100);
    	category = "招聘";
    	ps.processTrainSet(dataPath, category);
    	
    	dataPath = makeDataFilePaths("C000023","txt",10,100);
    	category = "文化";
    	ps.processTrainSet(dataPath, category);
    	
    	dataPath = makeDataFilePaths("C000024","txt",10,100);
    	category = "军事";
    	ps.processTrainSet(dataPath, category);   	  	
    }
    
    public static String[] makeDataFilePaths(String dataFileDir,String type,int start,int end){
    	String de[] = new String[end-start+1];
        for(int i = start,j=0;i<=end;i++,j++)
        	de[j] = dataFileDir+File.separator+i+"."+type;
        return de;
    }
}
