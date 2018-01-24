package com.brt.web;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.lang3.StringUtils;
import org.jasig.cas.client.authentication.AttributePrincipal;
import org.jasig.cas.client.util.AssertionHolder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.brt.util.CookieUtils;
import com.brt.util.JsonUtil;
import com.brt.config.SpringCasAutoconfig;

@Controller
public class CASController { 
	
	@Autowired
	private SpringCasAutoconfig autoconfig;
	
	private JsonUtil jsonutil = new JsonUtil();
	private CookieUtils cookieutil = new CookieUtils();

	@RequestMapping(value={"/","/index"})
	@ResponseBody
	public String index(HttpServletRequest request, HttpServletResponse response){
		
		AttributePrincipal principal = (AttributePrincipal)request.getUserPrincipal();
		
		String result = "sessionId:"+request.getSession().getId()+"</br>";
		result += "request.getRemoteUser():"+request.getRemoteUser()+"</br>";
		result += "request.getUserPrincipal():"+request.getUserPrincipal()+"</br>";
		result += "principal.getName():"+principal.getName()+"</br>";
		if(principal!=null){
			Map<String,Object> map = principal.getAttributes();
			for (String key : map.keySet()) {
				result += key+"  :  "+map.get(key)+"</br>";
			}
			
		}
		return "execute index method </br>"+result;
	}
	@RequestMapping("/test")
	@ResponseBody
	public String test(HttpServletRequest request, HttpServletResponse response){
		AttributePrincipal principal = (AttributePrincipal)request.getUserPrincipal();
		String result = "sessionId:"+request.getSession().getId()+"</br>";
		result += "request.getRemoteUser():"+request.getRemoteUser()+"</br>";
		result += "request.getUserPrincipal():"+request.getUserPrincipal()+"</br>";
		result += "principal.getName():"+principal.getName()+"</br>";
		if(principal!=null){
			Map<String,Object> map = principal.getAttributes();
			for (String key : map.keySet()) {
				result += key+"  :  "+map.get(key)+"</br>";
			}
			
		}
		return "execute test method </br>"+result;
	}
	
	@RequestMapping(value="/caslogin",method=RequestMethod.POST)
	@ResponseBody
	public String caslogin(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Map<String, String> casresult = validate("admin","whbrtggzn",true);
		String rurl = request.getRequestURL().toString();
		Cookie tgccookie = cookieutil.setCookie(response, "CASTGC", casresult.get("CASTGC"), request.getRequestURL().toString());
		response.addCookie(tgccookie);
		return jsonutil.toJson(casresult);
	}
	
	/*public  Map<String, String> validate(HttpServletRequest req) throws Exception {  
        String loginName = req.getParameter("loginName");  
        String password = req.getParameter("password");  
        boolean rememberMe = false;  
        if (StringUtils.isNotBlank(req.getParameter("rememberMe"))) {  
            rememberMe = true;  
        }  
        return validate(loginName, password, rememberMe);  
    }  */
  
 
    public Map<String, String> validate(String loginName, String password, boolean rememberMe) throws Exception {  
        String loginUrl = autoconfig.getCasServerLoginUrl();
        //LOG.info("[{}]开始登录", loginName);  
        HttpClient httpclient = new HttpClient();  
        PostMethod method = new PostMethod();  
        Map<String, String> params = getParams(loginUrl);  
        String lt = params.get("lt");  
        String execution = params.get("execution");  
        String cookie = params.get("Set-Cookie");  
        String reqCnt = "username=" + URLEncoder.encode(loginName,"UTF-8") + "&password=" + URLEncoder.encode(password,"UTF-8") + "&lt="  
                + URLEncoder.encode(lt) + "&execution=" + execution + "&_eventId=submit&submit=LOGIN";  
        if (rememberMe) {  
            reqCnt = reqCnt + "&rememberMe=true";  
        }  
        method.setRequestBody(reqCnt);  
        method.setFollowRedirects(false);  
        method.addRequestHeader("Content-Type", "application/x-www-form-urlencoded");  
        method.addRequestHeader(new Header("Cookie", cookie));  
        method.setPath(loginUrl);  
        httpclient.executeMethod(method);  
        String casTgtCookie = null;  
        Header tgtHead = method.getResponseHeader("Set-Cookie");  
        if (tgtHead != null) {  
            casTgtCookie = tgtHead.getValue();  
        }  
        Map<String, String> resp = new HashMap<String, String>();  ;  
        resp.put("CASTGC", casTgtCookie);  
        resp.put("msg", "登录成功");  
        System.out.println(casTgtCookie);  
        String respStr = method.getResponseBodyAsString();  
        if (StringUtils.contains(respStr, "登录成功")) {  
            //LOG.info("loginName[{}]登录成功", loginName);  
            /*IAuthenticationService aService = (IAuthenticationService) BdpHessianProxy  
                    .getService(IAuthenticationService.class, "authenticationService");  
            User user = aService.getUserByLoginName(loginName); */ 
            //String userCode = AssertionHolder.getAssertion().getPrincipal().getName();//user.getCode().toString();  
            String ticket = StringUtils.substringBetween(tgtHead.getValue(), "CASTGC=", "; Expires=");  
            //resp.put("userCode", userCode);  
            resp.put("ticket", ticket);  
            String jssionid = StringUtils.substringBetween(cookie, "JSESSIONID=","; Path=");  
            resp.put("jssionid", jssionid);  
            //cache.set(userCode, ticket, CookieUtil.TICKET_EXPIRE_TIME);  
            return resp;  
        }  
        Document doc = Jsoup.parse(respStr);  
        String msg = doc.select(".errors").text();  
        resp.put("msg", msg);  
        //LOG.info("loginName[{}]登录失败[{}]", loginName, msg);  
  
        return resp;  
  
    }  
  
   /* public static void main(String[] args) throws Exception {  
        validate("张三", "111", false);  
    }  */
  
    public Map<String, String> getParams(String loginUrl) throws Exception {  
        Map<String, String> params = new HashMap<String, String>();  
        HttpClient httpclient = new HttpClient();  
        HttpMethod method = new GetMethod();  
        method.setPath(loginUrl);  
        method.setFollowRedirects(false);  
        httpclient.executeMethod(method);  
        String cont = method.getResponseBodyAsString();  
        Document doc = Jsoup.parse(cont);  
        params.put("Set-Cookie", method.getResponseHeader("Set-Cookie").getValue());  
        params.put("lt", doc.getElementsByAttributeValue("name", "lt").attr("value"));  
        params.put("execution", doc.getElementsByAttributeValue("name", "execution").attr("value"));  
        return params;  
    }  
}
