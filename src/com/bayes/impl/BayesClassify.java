package com.bayes.impl;

import java.io.FileNotFoundException;
import java.io.IOException;

import test.Spliter;

public class BayesClassify {
	 private Category[] categories;
	 
     public BayesClassify(String categories[]) throws FileNotFoundException{
    	 this.categories = Category.getCategorySet(categories);
     }
     
     public String classifyText(String text) throws IOException{
    	 String a[] = Spliter.splitText(text);           //x
    	 double p[] = new double[categories.length];     //p(yi|x)
    	 int cc[] = new int[this.categories.length];     //��¼ÿ�������ʵ�У׼����ϵ��
    	 
    	 for(int i=0;i<this.categories.length;i++){
    		 int LaplaceCalibration = 0;                 //������˹У׼��
    		 for(int j=0;j<a.length;j++){
    			if(categories[i].getCount().get(a[j])==null)
    				LaplaceCalibration++;
    		 }
    		 for(int j=0;j<a.length;j++){
    		    Integer in = this.categories[i].getCount().get(a[j]);
    		    int s = in==null?1:( in.intValue()+LaplaceCalibration );
    		    int d = this.categories[i].getCount_num()+LaplaceCalibration;
    		    double p_one = ((double)s)/((double)d);
    		    p[i] = j==0?p_one:(p[i]*p_one);    		    
    		    MPBean add = MP(p[i]);
    		    cc[i] += add.getC();
    		    p[i]  = add.getP();
    		 }
    	 }
    	 
    	 int min_cc = cc[0],max_i=0;
    	 for(int i=0;i<cc.length;i++){
    		 if(min_cc>=cc[i]){
    			 if(min_cc==cc[i])
    				max_i = p[max_i]>p[i]?max_i:i;
    			 else{
    				min_cc = cc[i];
    				max_i = i;
    			 }
    		 }
    	 }
    	 return this.categories[max_i].getCategory();
     }
     
     /**
      * �ƶ�С���㱣�ָ�������1~10��Χ��
      * @param lf
      * @return
      */
     private MPBean MP(double lf){
    	 int c = 0;
    	 if(lf<1){
    		 while(lf<1){
        		 lf*=10;
        		 c++;
        	 }        	 
    	 }
    	 else if(lf>10){
    		 while(lf>10){
    			 lf/=10;
    			 c--;
    		 }
    	 }
    	 return new MPBean(lf,c);	 
     }
}
