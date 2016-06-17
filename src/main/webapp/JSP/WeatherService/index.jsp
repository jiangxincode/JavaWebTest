<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <script type="text/javascript" src="jquery-1.8.2.js"></script>
  </head>
  
  <body>
   <select id="province">
   <option value="31124">广东省</option>
   </select>
   <select id="city">
   <option value="2350">广州</option>
   <option value="2419">深圳</option>
   <option value="2351">东莞</option>
   </select>
   <hr/>
   <span>XXXX</span>
   <script type="text/javascript">
     $("#city").change(function(){
       var city=$("#city option:selected").val();
       $.post("weatherServlet",{"city":city},function(backdata){
         $("span").text(backdata).css("color","blue");
       });
     });
   </script>
  </body>
</html>
