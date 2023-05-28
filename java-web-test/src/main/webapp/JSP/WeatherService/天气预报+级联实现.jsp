<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript" src="jquery-1.3.js"></script>
</head>
<script type="text/javascript">
	$(function() {
		var province=[{id:'31122',name:'贵州'},{id:'31123',name:'四川'},{id:'31124',name:'广东'}];
		var citys=new Array();
		citys['31122']=['1747,贵阳','1683,金沙'];
		citys['31123']=['1501,巴中','1547,广安'];
		citys['31124']=['2279,韶关','2419,深圳','2350,广州'];
		// 开始给一级下拉列表框赋值
		for(var i=0;i<province.length;i++){
			$("#province").append("<option value=" + province[i].id + " >" + province[i].name + "</option>");
		}
		// 给一级下拉列表框注册事件
		$("#province").change(function(){
			// 开始给二级下拉列表框赋值
			$("#city").find("option").not(":first").remove();
			var val=$(this).val();
			if(val!=0){
				for(var i=0;i<citys[val].length;i++){
					var data=citys[val][i].split(",");
					$("#city").append("<option value=" + data[0] + " >" + data[1] + "</option>");
				}
			}
		});
		// 发送请求查看天气预报
		$("#city").change(function(){
			var val=$("#city").val();
			if(val!="0"){
				$.post("WeatherSer",{id:val},function(data){
					alert(data);
				},"json");
			}
		});
	});
</script>

<body>
	省:<select id="province">
		  <option value="0">请选择</option>
	  </select>
	市:<select id="city">
		  <option value="0">请选择</option>
	   </select>
</body>
</html>
