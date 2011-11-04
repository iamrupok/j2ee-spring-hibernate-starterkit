package com.ekit.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.time.DateUtils;

/**
 * This class deal with formatting of parameters of different types from one to
 * another type
 */
public class ParamUtil {
   

    private static SimpleDateFormat dateFormat;
    private static String[] datePatterns = { "yyyy-MM-dd HH:mm:ss", "MM-dd-yyyy" };

    /**
     * Static initializer block of code getting the dateFormat
     */
    static {
	dateFormat = new SimpleDateFormat("MM-dd-yyyy");
    }

    /**
     * Formats a date
     * 
     * @param date
     * @return String
     */
    public static String formatDate(Date date) {
	if(date == null)
	    return null;
	String returnString = dateFormat.format(date);
	return returnString;
    }
    /**
     * Parse a date string to Date
     * 
     * @param date
     * @return
     */
    public static Date parseDate(String date) {
	try {
	    Date returnDate = DateUtils.parseDate(date, datePatterns);
	    return returnDate;
	} catch(ParseException pe) {
	    
	    return null;
	}
    }

    /**
     * Parse a date string to a specified format
     * 
     * @param date
     * @param customDateFormat
     * @return Date
     */
    public static Date parseDate(String date, String customDateFormat) {
	try {
	    Date returnDate = DateUtils.parseDate(date, (new String[] { customDateFormat }));
 
	    return returnDate;
	} catch(ParseException pe) {
	   
	    return null;
	}
    }

    /**
     * Checks if a parameter exists in the request object
     * 
     * @param request
     * @param paramName
     * @return boolean
     */
    public static boolean exists(HttpServletRequest request, String paramName) {
		boolean returnboolean = exists(request.getParameter(paramName));
		return returnboolean;
    }

    /**
     * Checks if a parameter is null or empty value
     * 
     * @param param
     * @return boolean
     */
    public static boolean exists(String param) {
		boolean returnboolean = (param == null || param.trim().equals("")) ? false : true;
		return returnboolean;
    }

    /**
     * Checks if a parameter empty
     * 
     * @param param
     * @return boolean
     */
    public static boolean empty(String param) {
		boolean returnboolean = param.trim().equals("");
		return returnboolean;
    }

    /**
     * Checks if a parameter value is integer type or not.
     * 
     * @param param
     * @return boolean
     */
    public static boolean isInt(String param) {
	    if(!exists(param)) {
		    return false;
		}
		boolean caught = false;
		try {
		    Integer.parseInt(param);
		} catch(NumberFormatException e) {
		    caught = true;
		}
		boolean returnboolean = caught ? false : true;
		return returnboolean;
    }

    /**
     * Checks if a parameter value is double type or not.
     * 
     * @param param
     * @return boolean
     */
    public static boolean isDouble(String param) {
	
    	if(!exists(param))
	    return false;
		boolean caught = false;
		try {
		    Double.parseDouble(param);
		} catch(NumberFormatException e) {
		    caught = true;
		}
		boolean returnboolean = caught ? false : true;
		return returnboolean;
    }

    /**
     * Checks if a parameter value is float type or not.
     * 
     * @param param
     * @return boolean
     */
    public static boolean isFloat(String param) {
	
		if(!exists(param)) {
		    return false;
		}
		boolean caught = false;
		try {
		    Float.parseFloat(param);
		} catch(NumberFormatException e) {
		    caught = true;
		}
		boolean returnboolean = caught ? false : true;
		return returnboolean;
    }

    /**
     * Checks if a parameter value is date type or not.
     * 
     * @param param
     * @return boolean
     */
    public static boolean isDate(String param) {
		
    	if(!exists(param)) {
		    return false;
		}
		boolean caught = false;
			try {
				dateFormat.parse(param);
		} catch(ParseException e) {
		   	caught = true;
		}
	
		boolean returnboolean = caught ? false : true;
		return returnboolean;
    }

    /**
     * generate a String value with letter and digit
     * 
     * @param description
     * @param id
     * @return string
     */
    public static String buildParamName(String description, int id) {
	
		StringBuilder sb = new StringBuilder();
		char[] chars = description.toCharArray();
		for(char c : chars) {
		    if(Character.isLetterOrDigit(c)) {
			sb.append(c);
		    }
		    sb.append(id);
		}
		String returnString = sb.toString();
		return returnString;
    }

    /**
     * gets the integer value of parameter
     * 
     * @param request
     * @param paramName
     * @return integer
     */
    public static int getInt(HttpServletRequest request, String paramName) {
		int returnint = getInt(request.getParameter(paramName));
		return returnint;
    }

    /**
     * Convert a string parameter to integer type
     * 
     * @param param
     * @return int
     */
    public static int getInt(String param) {
		int ret = 0;
		if(exists(param) && isInt(param)) {
		    ret = Integer.parseInt(param);
		}
		return ret;
    }

    /**
     * gets the float value of parameter
     * 
     * @param request
     * @param paramName
     * @return float
     */
    public static float getFloat(HttpServletRequest request, String paramName) {
	
		float ret = 0;
		String paramStr = request.getParameter(paramName);
		if(exists(paramStr) && isFloat(paramStr)) {
		    ret = Float.parseFloat(paramStr);
		}
		return ret;
    }

    /**
     * get the Date from a param String
     * 
     * @param request
     * @param paramName
     * @return Date
     */
    public static Date getDate(HttpServletRequest request, String paramName) {
	
		Date ret = null;
		String paramStr = request.getParameter(paramName);
		if(exists(paramStr) && isDate(paramStr)) {
		    ret = parseDate(paramStr);
		}
		return ret;
    }

    /**
     * Convert a string parameter to time stamp
     * 
     * @param request
     * @param paramName
     * @return
     */
    public static Timestamp getTimestamp(HttpServletRequest request, String paramName) {
	
		Timestamp ret = null;
		Date date = getDate(request, paramName);
		if(date != null) {
		    ret = new Timestamp(date.getTime());
		}
		return ret;
    }

    public static String getString(String string) {
		if(string == null) {
	    
			return "";
		}
		return string;
    }

    /**
     * get string value from a string parameter
     * 
     * @param request
     * @param paramName
     * @return string
     */
    public static String getString(HttpServletRequest request, String paramName) {
			String ret = "";
			String paramStr = request.getParameter(paramName);
			if(exists(paramStr)) {
			    ret = paramStr;
			}
			return ret;
    }

    /**
     * converts string parameter to list
     * 
     * @param request
     * @param paramName
     * @return List
     */
    public static List<String> getStringArray(HttpServletRequest request, String paramName) {
	
		List<String> ret = new ArrayList<String>();
		String[] params = request.getParameterValues(paramName);
		if(params == null) {
		    return ret;
		}
		for(int i = 0; i < params.length; i++) {
		    ret.add(params[i]);
		}
		return ret;
    }

    /**
     * 
     * 
     * @param request
     * @param paramName
     * @return
     */
    public static List<Integer> getIntegerArray(HttpServletRequest request, String paramName) {
		List<Integer> returnList = getIntegerArray(request, paramName, ",");
		return returnList;
    }

    public static List<Integer> getIntegerArray(HttpServletRequest request, String paramName,
	    String delimiter) {
		List<Integer> ret = new ArrayList<Integer>();
		String[] params = request.getParameterValues(paramName);
		if(params == null) {
		    return ret;
		}
		if(params.length == 1 && params[0].indexOf(delimiter) != -1) {
		    params = params[0].split(delimiter);
		}
		for(int i = 0; i < params.length; i++) {
		    if(isInt(params[i])) {
			ret.add(Integer.parseInt(params[i]));
		    }
		}
		return ret;
    }

    /**
     * 
     * 
     * @param integers
     * @return
     */
    public static List<Integer> getIntegerArray(String integers) {
		List<Integer> returnList = getIntegerArray(integers, ",");
		return returnList;
    }

    /**
     * gets a integer list from string paramenter
     * 
     * @param integers
     * @param delimiter
     * @return
     */
    public static List<Integer> getIntegerArray(String integers, String delimiter) {
		List<Integer> ret = new ArrayList<Integer>();
		if(!exists(integers)) {
		    return ret;
		}
		String[] params = integers.split(delimiter);
		for(int i = 0; i < params.length; i++) {
		    if(isInt(params[i])) {
			ret.add(Integer.parseInt(params[i]));
		    }
		}
		return ret;
    }
    
}

