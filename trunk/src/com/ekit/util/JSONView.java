package com.ekit.util;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.json.JSONObject;
import org.springframework.web.servlet.View;



/**
 * Implementation of JSONView
 */
public class JSONView implements View {
   
    private String contentType = "application/json";

    public void render(Map map, HttpServletRequest request, HttpServletResponse response)
	    throws Exception {
	
		JSONObject jsonObject = new JSONObject(map);
		PrintWriter writer = response.getWriter();
		writer.write(jsonObject.toString());

   
    }

    public String getContentType() {
    	return contentType;
    }

}
