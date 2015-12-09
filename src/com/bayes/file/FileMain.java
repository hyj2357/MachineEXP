package com.bayes.file;

import java.io.File;
import java.io.IOException;

public class FileMain {
    public static void main(String args[]) throws IOException{
    	ProcessSample ps = new ProcessSample();
    	String dataPath[] = {"C000007/10.txt","C000007/11.txt","C000007/12.txt","C000007/13.txt","C000007/14.txt","C000007/15.txt","C000007/16.txt","C000007/17.txt","C000007/18.txt","C000007/19.txt"};
    	String category = "汽车";
    	ps.processTrainSet(dataPath, category);

    	//dataPath = new String[]{"C000008/10.txt","C000008/11.txt","C000008/12.txt","C000008/13.txt","C000008/14.txt","C000008/15.txt","C000008/16.txt","C000008/17.txt","C000008/18.txt","C000008/19.txt"};
    	dataPath = makeDataFilePaths("C000008","txt",10,100);
    	category = "军事";
    	category = "财经";
    	ps.processTrainSet(dataPath, category);
    	
    	//dataPath = new String[]{"C000010/10.txt","C000010/11.txt","C000010/12.txt","C000010/13.txt","C000010/14.txt","C000010/15.txt","C000010/16.txt","C000010/17.txt","C000010/18.txt","C000010/19.txt"};
    	dataPath = makeDataFilePaths("C000010","txt",10,100);
    	category = "军事";
    	category = "IT";
    	ps.processTrainSet(dataPath, category);
    	
    	//dataPath = new String[]{"C000013/10.txt","C000013/11.txt","C000013/12.txt","C000013/13.txt","C000013/14.txt","C000013/15.txt","C000013/16.txt","C000013/17.txt","C000013/18.txt","C000013/19.txt"};
    	dataPath = makeDataFilePaths("C000013","txt",10,100);
    	category = "军事";
    	category = "健康";
    	ps.processTrainSet(dataPath, category);
    	
    	//dataPath = new String[]{"C000014/10.txt","C000014/11.txt","C000014/12.txt","C000014/13.txt","C000014/14.txt","C000014/15.txt","C000014/16.txt","C000014/17.txt","C000014/18.txt","C000014/19.txt"};
    	dataPath = makeDataFilePaths("C000014","txt",10,100);
    	category = "军事";
    	category = "体育";
    	ps.processTrainSet(dataPath, category);
    	
    	//dataPath = new String[]{"C000016/10.txt","C000016/11.txt","C000016/12.txt","C000016/13.txt","C000016/14.txt","C000016/15.txt","C000016/16.txt","C000016/17.txt","C000016/18.txt","C000016/19.txt"};
    	dataPath = makeDataFilePaths("C000016","txt",10,100);
    	category = "军事";
    	category = "旅游";
    	ps.processTrainSet(dataPath, category);
    	
    	//dataPath = new String[]{"C000020/10.txt","C000020/11.txt","C000020/12.txt","C000020/13.txt","C000020/14.txt","C000020/15.txt","C000020/16.txt","C000020/17.txt","C000020/18.txt","C000020/19.txt"};
    	dataPath = makeDataFilePaths("C000020","txt",10,100);
    	category = "军事";
    	category = "教育";
    	ps.processTrainSet(dataPath, category);
    	
    	//dataPath = new String[]{"C000022/10.txt","C000022/11.txt","C000022/12.txt","C000022/13.txt","C000022/14.txt","C000022/15.txt","C000022/16.txt","C000022/17.txt","C000022/18.txt","C000022/19.txt"};
    	dataPath = makeDataFilePaths("C000022","txt",10,100);
    	category = "军事";
    	category = "招聘";
    	ps.processTrainSet(dataPath, category);
    	
    	//dataPath = new String[]{"C000023/10.txt","C000023/11.txt","C000023/12.txt","C000023/13.txt","C000023/14.txt","C000023/15.txt","C000023/16.txt","C000023/17.txt","C000023/18.txt","C000023/19.txt"};
    	dataPath = makeDataFilePaths("C000023","txt",10,100);
    	category = "军事";
    	category = "文化";
    	ps.processTrainSet(dataPath, category);
    	
    	//dataPath = new String[]{"C000024/10.txt","C000024/11.txt","C000024/12.txt","C000024/13.txt","C000024/14.txt","C000024/15.txt","C000024/16.txt","C000024/17.txt","C000024/18.txt","C000024/19.txt"};
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
