function validate(){
	var ele = document.getElementById("guess_input");
	if(!ele){alert("�Ҳ��������");return false;}
	var v = ele.value;
	var pass = true;
	if(v == "")pass = false;
	if(/[^\d]/.test(v))pass = false;
	if(!pass){alert("�����д���");return false;}
	return true;
}