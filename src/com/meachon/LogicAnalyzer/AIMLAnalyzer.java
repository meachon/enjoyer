package com.meachon.LogicAnalyzer;

import java.util.regex.Pattern;

import javax.xml.parsers.*;

import org.xml.sax.*;
import org.w3c.dom.*;

public class AIMLAnalyzer {
	public AIMLAnalyzer()
	{
		
	}
	
	public Response AIMLAnalyzerService(Request request, Response response)
	{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try{
			DocumentBuilder db = dbf.newDocumentBuilder();
			String rootdir = getClass().getResource("/").getFile().toString();
			Document doc = db.parse(rootdir + "../data/index.xml");
			
			NodeList categoryList = doc.getElementsByTagName("category");
			for(int i=0; i<categoryList.getLength(); i++)
			{
				Node category = categoryList.item(i);
				
				boolean patternFlag = false;
				NodeList categoryChildList = category.getChildNodes();
				for(int j=0; j<categoryChildList.getLength(); j++)
				{
					if(Node.ELEMENT_NODE != categoryChildList.item(j).getNodeType())
					{
						continue;
					}
					
					Node categoryChildItem = categoryChildList.item(j);
					
					System.out.println("j:" + j);
					System.out.println("categoryChildItem name:" + categoryChildItem.getNodeName());
					System.out.println("categoryChildItem value:" + categoryChildItem.getTextContent());

					if((categoryChildItem.getNodeName().equals("pattern")) 
							&& (Pattern.matches(categoryChildItem.getTextContent(), request.contextValue)) )
					{
						//System.out.println("pattern successfully!");
						patternFlag = true;
					}
					else if((categoryChildItem.getNodeName().equals("template")) 
							&& (true == patternFlag) ) 
					{
						response.contextValue = categoryChildItem.getTextContent(); 
						return response;
					}
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
	}
	
}
