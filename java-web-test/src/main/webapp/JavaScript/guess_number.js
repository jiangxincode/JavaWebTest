function validate() {
	var ele = document.getElementById("guess_input");
	if (!ele) {
		alert("找不到输入框！");
		return false;
	}
	var v = ele.value;
	var pass = true;
	if (v == "")
		pass = false;
	if (/[^\d]/.test(v))
		pass = false;
	if (!pass) {
		alert("输入有错误！");
		return false;
	}
	return true;
}