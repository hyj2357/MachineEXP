package test;

import java.io.IOException;
import java.io.StringReader;

import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

public class Spliter {
	public static void main(String[] args) throws IOException {
		String text="微软公司提出以446亿美元的价格收购雅虎中国网2月1日报道 美联社消息，微软公司提出以446亿美元现金加股票的价格收购搜索网站雅虎公司。微软提出以每股31美元的价格收购雅虎。微软的收购报价较雅虎1月31日的收盘价19.18美元溢价62%。微软公司称雅虎公司的股东可以选择以现金或股票进行交易。微软和雅虎公司在2006年底和2007年初已在寻求双方合作。而近两年，雅虎一直处于困境：市场份额下滑、运营业绩不佳、股价大幅下跌。对于力图在互联网市场有所作为的微软来说，收购雅虎无疑是一条捷径，因为双方具有非常强的互补性。(小桥)";  
        StringReader sr=new StringReader(text);  
        IKSegmenter ik=new IKSegmenter(sr, true);  
        Lexeme lex=null;  
        while((lex=ik.next())!=null){  
            System.out.print(lex.getLexemeText()+"|");  
        }    
	}
}
