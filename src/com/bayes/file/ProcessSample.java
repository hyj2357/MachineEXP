package com.bayes.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import test.Spliter;

public class ProcessSample {
    public boolean processTrainSet(String dataPath[], String category) throws IOException{
    	
    	if(dataPath.length==0)
    		return false; 
    	String j = System.getProperty("user.dir")+File.separator+"dataSet"+File.separator+"Sample"+File.separator+"count"+File.separator+category+".txt";
    	File f = new File(System.getProperty("user.dir")+File.separator+"dataSet"+File.separator+"Sample"+File.separator+"count"+File.separator+category+".txt");    		
    	if(!f.exists())
    			f.createNewFile();
        OutputStream fotps = new FileOutputStream(f);    	
    	Map<String,Integer> count = new HashMap<String,Integer>();
    	
        for(int i=0;i<dataPath.length;i++){
    		File dt = new File(System.getProperty("user.dir")+File.separator+"dataSet"+File.separator+"Sample"+File.separator+dataPath[i]);
    		Scanner sc = new Scanner(dt);
    		String text = "";
    		while(sc.hasNextLine())
    			text += sc.nextLine();
    		Spliter.getTextCount(count,text);
    		sc.close();
    	}
        
        String writeContent = "";
        Set keys = count.keySet();
        Iterator itr = keys.iterator();
        int count_num = 0;
        while(itr.hasNext()){
        	String key = (String)itr.next();
        	writeContent +=  "\r\n" + key + ":" + ((Integer)count.get(key)).intValue() ;
            count_num += ((Integer)count.get(key)).intValue();
        }
        writeContent = count_num + writeContent;
        fotps.write(writeContent.getBytes());
        fotps.close();
    	return true;
    }
}
