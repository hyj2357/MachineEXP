package test;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

public class Spliter {
	public final static String PFIX = "^[\\u4e00-\\u9fa5]*[a-z]*[A-Z]*[0-9]*";
	public final static String SFIX = "+[\\u4e00-\\u9fa5]*[a-z]*[A-Z]*[0-9]*$";
	public static final String NOMEAN[] = {"��", "����","Ҫ","�Լ�","֮","��","��","��","��","��","��","��","Ӧ","��","ĳ","��","��","��","λ","��","һ","��","��","��","��","��","��","��",""};
    public static final String REGEX[] = new String[NOMEAN.length];
    
	public static void main(String[] args) throws IOException {
		String text="΢��˾�����446����Ԫ�ļ۸��չ��Ż��й���2��1�ձ��� ��������Ϣ��΢��˾�����446����Ԫ�ֽ�ӹ�Ʊ�ļ۸��չ�������վ�Ż���˾��΢�������ÿ��31��Ԫ�ļ۸��չ��Ż���΢����չ����۽��Ż�1��31�յ����̼�19.18��Ԫ���62%��΢��˾���Ż���˾�Ĺɶ�����ѡ�����ֽ���Ʊ���н��ס�΢����Ż���˾��2006��׺�2007�������Ѱ��˫���������������꣬�Ż�һֱ�����������г��ݶ��»�����Ӫҵ�����ѡ��ɼ۴���µ���������ͼ�ڻ������г�������Ϊ��΢����˵���չ��Ż�������һ���ݾ�����Ϊ˫�����зǳ�ǿ�Ļ����ԡ�(С��)";  
        StringReader sr=new StringReader(text);  
        IKSegmenter ik=new IKSegmenter(sr, true);  
        Lexeme lex=null;  
        while((lex=ik.next())!=null){  
            System.out.print(lex.getLexemeText()+"|");  
        }    
	}
	
	/**
	 * 
	 * @param text
	 * @return
	 * @throws IOException 
	 */
	public static String[] splitText(String text) throws IOException{
		String splitContent = "";
		StringReader sr=new StringReader(text);  
        IKSegmenter ik=new IKSegmenter(sr, true);  
        Lexeme lex=null;  
        while((lex=ik.next())!=null)
        	splitContent += lex.getLexemeText()+":";
           // System.out.print(lex.getLexemeText()+"|");
        return splitContent.split(":");
	}
	
	/**
	 * ��ȡĳ���ı��е����д�Ƶ����Ƶ��
	 * @param count  �ʻ����ƵMap
	 * @param text  �����ı�
	 * @return  ����õĴʻ����ƵMap
	 * @throws IOException
	 */
	public static Map<String,Integer> getTextCount(Map<String,Integer> count,String text) throws IOException{
        StringReader sr=new StringReader(text);  
        IKSegmenter ik=new IKSegmenter(sr, true);  
        Lexeme lex=null;       
        if(REGEX[0]==""||REGEX[0]==null){
            for(int i=0;i<NOMEAN.length;i++){
            	  char r[]  = NOMEAN[i].toCharArray();
            	  String content = "[";
            	  for(char j:r)
            	    content += "\\u"+Integer.toHexString((int)j);
            	  content += "]";
            	  REGEX[i] = PFIX + content + SFIX; 
            	  //System.out.println(NOMEAN[i]+":"+content);
            }
        }
        while((lex=ik.next())!=null){
        	String lexString = lex.getLexemeText();
        	if(isInNOMEAN(lexString))
        		continue;
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
	
	/**
	 * �ж��Ƿ���������弯���еĴʻ��ǲ����ı���������
	 * @param text �����ı�
	 * @return 
	 */
	private static boolean isInNOMEAN(String text){
		for(int i=0;i<REGEX.length-1;i++){
			if(Pattern.matches(REGEX[i], text))
				return true;
		}
		return false;
	}
}
