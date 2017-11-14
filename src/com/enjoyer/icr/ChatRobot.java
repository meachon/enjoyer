package com.enjoyer.icr;   //Intelligent Chat Robot

import com.meachon.LogicAnalyzer.AIMLAnalyzer;
import com.meachon.LogicAnalyzer.Request;
import com.meachon.LogicAnalyzer.Response;

public class ChatRobot {

	public String RobotChatResponse(String request)
	{
		Response responseContext = new Response("");
		Request requestContext = new Request(request);

		AIMLAnalyzer analyzer = new AIMLAnalyzer();
		analyzer.AIMLAnalyzerService(requestContext, responseContext);
		
		return responseContext.contextValue;
	}
}
