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
    		    int s = in==null?0:in.intValue();
    		    int d = this.categories[i].getCount_num();
    		    Double p_one = new Double(((double)s)/((double)d));
    		    cc[i] += MP(p_one);
    		    p[i]*=p_one.doubleValue();
    		 }
    	 }
    	 
    	 int max=cc[0];
    	 for(int i=0;i<cc.length;i++)             //��ȡ����У׼����ϵ��
    		 max = max>=cc[i]?max:cc[i];
    	 for(int i=0;i<p.length;i++)              //����ÿ�����ʵĳ���ͳһУ׼
    		 for(int j=0;j<max-cc[i];j++)
    			 p[i]*=10;
    	 
    	 double max_p = p[0];     //������
    	 int max_i = 0;        //�������±�         
    	 for(int i=0;i<p.length;i++){
    		 max_p = max_p>=p[i]?max_p:p[i];
    		 max_i = max_p>=p[i]?max_i:i;
    	 }
    	 return this.categories[max_i].getCategory();
     }
     
     /**
      * С��������������������һ�Է�ֹ��������С
      * @param lf
      * @return
      */
     private int MP(Double lf){
    	 int c = 0;
    	 while(lf<1){
    		 lf = new Double(lf.doubleValue()*10);
    		 c++;
    	 }
    	 return c;	 
     }
}
