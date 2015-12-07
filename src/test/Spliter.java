package test;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

public class Spliter {
	public static final String NOMEAN[] = {"��", "����","Ҫ","�Լ�","֮","��","��","��","��","��","��","��","Ӧ","��","ĳ","��","��","��","λ","��","һ","��","��","��","��","��","��","��",""};
	public static void main(String[] args) throws IOException {
		String text="΢��˾�����446����Ԫ�ļ۸��չ��Ż��й���2��1�ձ��� ��������Ϣ��΢��˾�����446����Ԫ�ֽ�ӹ�Ʊ�ļ۸��չ�������վ�Ż���˾��΢�������ÿ��31��Ԫ�ļ۸��չ��Ż���΢����չ����۽��Ż�1��31�յ����̼�19.18��Ԫ���62%��΢��˾���Ż���˾�Ĺɶ�����ѡ�����ֽ���Ʊ���н��ס�΢����Ż���˾��2006��׺�2007�������Ѱ��˫���������������꣬�Ż�һֱ�����������г��ݶ��»�����Ӫҵ�����ѡ��ɼ۴���µ���������ͼ�ڻ������г�������Ϊ��΢����˵���չ��Ż�������һ���ݾ�����Ϊ˫�����зǳ�ǿ�Ļ����ԡ�(С��)";  
        StringReader sr=new StringReader(text);  
        IKSegmenter ik=new IKSegmenter(sr, true);  
        Lexeme lex=null;  
        while((lex=ik.next())!=null){  
            System.out.print(lex.getLexemeText()+"|");  
        }    
	}
	
	public static Map<String,Integer> getTextCount(Map<String,Integer> count,String text) throws IOException{
        StringReader sr=new StringReader(text);  
        IKSegmenter ik=new IKSegmenter(sr, true);  
        Lexeme lex=null;  
        while((lex=ik.next())!=null){
        	String lexString = lex.getLexemeText();
        	if(count.get(lexString)==null)
        		count.put(lexString, new Integer(1));
        	else{
        		int value = ((Integer)count.get(lexString)).intValue();
        		count.put(lexString, new Integer(value+1));
        	}           
            System.out.print(lex.getLexemeText()+"|");  
        } 		
		return count;
	}
}
