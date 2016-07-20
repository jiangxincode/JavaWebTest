<#assign s=JspTaglibs["/WEB-INF/struts-tags.tld"] /> <#--这一句是为了让Freemarker识别struts2的标签 -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">

    <title>My JSP 'index.jsp' starting page</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
  </head>
  <body>
    <h1>${companyName}</h1>
    <@s.form action="reg" >
        <@s.textfield label="用户名" name="uname"  />
        <@s.submit />
    </@s.form>
  </body>
</html>
