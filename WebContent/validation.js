/**
 * 
 */

function valid() {
	var a = document.getElementById("ueid").value;
	var b = document.getElementById("uname").value;
	var c = document.getElementById("upass").value;
	var d = document.getElementById("esal").value;
	var e = document.getElementById("uimg").value;
	var flag = true;
	document.getElementById("uiderr").innerHTML = "";
	document.getElementById("unameerr").innerHTML = "";
	document.getElementById("esalerr").innerHTML = "";
	document.getElementById("uimgerr").innerHTML = "";
	document.getElementById("upasserr").innerHTML = "";
	if (checkMandatory(a)) {
		document.getElementById("uiderr").innerHTML = "Please Enter Id First;";
		flag = false;
	}
	if (checkMandatory(b)) {
		document.getElementById("unameerr").innerHTML = "Please Enter Empl Name:";
		flag = false;
	}
	if (checkMandatory(c)) {
		document.getElementById("upasserr").innerHTML = "Please Enter Password";
		flag = false;
	}
	if (checkMandatory(d)) {
		document.getElementById("esalerr").innerHTML = "Please Enter Salary";
		flag = false;
	}
	if (checkMandatory(e)) {
		document.getElementById("uimgerr").innerHTML = "Please Enter url form image";
		flag = false;
	}
	return flag;

}

function checkMandatory(st) {
	if (st.length == 0) {
		return true;
	}
	return false;
}

function login() {
	document.getElementById("utexterr").innerHTML = "";
	document.getElementById("upasserr").innerHTML = "";
	document.getElementById("utexterr1").innerHTML = "";

	var a = document.getElementById("utext").value;
	var b = document.getElementById("upass").value;
	var flag = true;
	var pat = /^[0-9]{1,}$/;

	if (!pat.test(a)) {
		document.getElementById("utexterr1").innerHTML = "Please Enter Numeric id";
		flag = false;
	}
	if (!pat.test(b)) {
		document.getElementById("upasserr").innerHTML = "Please Enter Numeric id";
		flag = false;
	}
	if (checkMandatory(a)) {
		document.getElementById("utexterr").innerHTML = "Please Enter User id";
		flag = false;
	}
	if (checkMandatory(b)) {
		document.getElementById("upasserr").innerHTML = "Please Enter password";
		flag = false;
	}

	return flag;

}