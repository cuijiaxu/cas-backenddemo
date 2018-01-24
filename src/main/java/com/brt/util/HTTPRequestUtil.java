package com.brt.util;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @author cjx
 *
 */
public class HTTPRequestUtil {

	//字符串读取
	public String charReader(HttpServletRequest request) throws IOException {

		BufferedReader br = request.getReader();
		String str, wholeStr = "";
		while((str = br.readLine()) != null){
		wholeStr += str;
		}

		//System.out.println(wholeStr);
		return  wholeStr;
	}
	
	//二进制读取

	void binaryReader(HttpServletRequest request) throws IOException {

		int len = request.getContentLength();
		ServletInputStream iii = request.getInputStream();
		byte[] buffer = new byte[len];
		iii.read(buffer, 0, len);

	}
}
