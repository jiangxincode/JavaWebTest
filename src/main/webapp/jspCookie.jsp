<%@ page import="javax.servlet.http.Cookie" %>
<html>
<head><title>jspCookie.jsp</title></head>
<body>
     <%!
		int count1 = 0;
		int count2 = 0;
    %>
    <%
    		Cookie cookie = new Cookie("cookieName" + count1++, "cookieValue" + count2++);
    		cookie.setMaxAge(10);
            response.addCookie(cookie);
    %>
    <%
            Cookie[] cookies = request.getCookies();
            if(cookies==null)
            	return;
            for(int i = 0; i < cookies.length; i++)
            {
    %>
    <p>
            <b>Cookie name:</b>
            <%= cookies[i].getName() %>

            <b>Cookie value:</b>
            <%= cookies[i].getValue() %>
    </p>
    
    <%
            }
    %>
   

</body></html>
