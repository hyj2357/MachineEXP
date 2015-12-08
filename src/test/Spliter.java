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
	public static final String NOMEAN[] = {"的", "我们","要","自己","之","将","“","”","，","（","）","后","应","到","某","后","个","是","位","新","一","两","在","中","或","有","更","好",""};
    public static final String REGEX[] = new String[NOMEAN.length];
    
	public static void main(String[] args) throws IOException {
		String text="微软公司提出以446亿美元的价格收购雅虎中国网2月1日报道 美联社消息，微软公司提出以446亿美元现金加股票的价格收购搜索网站雅虎公司。微软提出以每股31美元的价格收购雅虎。微软的收购报价较雅虎1月31日的收盘价19.18美元溢价62%。微软公司称雅虎公司的股东可以选择以现金或股票进行交易。微软和雅虎公司在2006年底和2007年初已在寻求双方合作。而近两年，雅虎一直处于困境：市场份额下滑、运营业绩不佳、股价大幅下跌。对于力图在互联网市场有所作为的微软来说，收购雅虎无疑是一条捷径，因为双方具有非常强的互补性。(小桥)";  
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
	 * 获取某段文本中的所有词频与总频率
	 * @param count  词汇与词频Map
	 * @param text  处理文本
	 * @return  处理好的词汇与词频Map
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
	 * 判断是否存在无意义集合中的词汇是测试文本的子序列
	 * @param text 测试文本
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
