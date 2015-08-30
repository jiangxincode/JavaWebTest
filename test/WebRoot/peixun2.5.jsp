<%@ page language="java"  pageEncoding="gb2312"%>
<%! int condition;%>
<html>
	<head>
	<title> test </title>
	</head>
	<body>
<%
	condition=1;
	switch(condition)
	{
			case 0:
			out.println("You must select condition 0!"+"<br>");
      		break;
      		case 1:
      		out.println("You must select condition 1!"+"<br>");
			break;
      		case 2:
			out.println("You must select condition 2!"+"<br>");
      	 	break;
      		default:
		 	out.println("Your select not in \"0,1,2\",select again!!"+"<br>");
		}
	%>     	      			
	</body>
</html>
