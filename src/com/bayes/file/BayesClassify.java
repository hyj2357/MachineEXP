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
    	 int cc[] = new int[this.categories.length];     //记录每个类别概率的校准乘数系数
    	 
    	 for(int i=0;i<this.categories.length;i++){
    		 int LaplaceCalibration = 0;                 //拉普拉斯校准数
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
    	 for(int i=0;i<cc.length;i++)             //获取最大的校准乘数系数
    		 max = max>=cc[i]?max:cc[i];
    	 for(int i=0;i<p.length;i++)              //进行每个概率的乘数统一校准
    		 for(int j=0;j<max-cc[i];j++)
    			 p[i]*=10;
    	 
    	 double max_p = p[0];     //最大概率
    	 int max_i = 0;        //最大概率下标         
    	 for(int i=0;i<p.length;i++){
    		 max_p = max_p>=p[i]?max_p:p[i];
    		 max_i = max_p>=p[i]?max_i:i;
    	 }
    	 return this.categories[max_i].getCategory();
     }
     
     /**
      * 小数点左移至浮点数大于一以防止浮点数过小
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
