package com.bayes.file;

import java.io.IOException;

public class Main {
    public static void main(String args[]) throws IOException{
    	ProcessSample ps = new ProcessSample();
    	String dataPath[] = {"C000007/10.txt","C000007/11.txt","C000007/12.txt","C000007/13.txt","C000007/14.txt","C000007/15.txt","C000007/16.txt","C000007/17.txt","C000007/18.txt","C000007/19.txt"};
    	String category = "Æû³µ";
    	ps.processTrainSet(dataPath, category);
    }
}
