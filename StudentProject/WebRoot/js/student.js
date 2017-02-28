
function validate() {
	return validateName() && validatePass();
}

function validateName() {
	var nameObj = document.getElementById("username");
	var nameMsg = document.getElementById("usernameMsg");
	if (nameObj.value.length > 0) {
		nameObj.className = "success";
		nameMsg.className = "right";
		return true;
	} else {
		nameObj.className = "fail";
		nameMsg.className = "wrong";
		return false;
	}
}

function validatePass() {
	var passObj = document.getElementById("password");
	var passMsg = document.getElementById("passwordMsg");
	if (passObj.value.length > 0) {
		passObj.className = "success";
		passMsg.className = "right";
		return true;
	} else {
		passObj.className = "fail";
		passMsg.className = "wrong";
		return false;
	}
}

function fun() {
	return window.confirm("确认删除？");
}

function selectAll(allStudent, Student) {
	var allObj = document.all(Student);
	if (allObj.length == undefined) {
		allObj.checked = document.getElementById(allStudent).checked;
	} else {
		for (var i = 0; i < allObj.length; i++) {
			allObj[i].checked = document.getElementById(allStudent).checked;
		}
	}
}

function banchConfirm(ele) {
	var count = 0;
	var allObj = document.all(ele);
	if (allObj.length == undefined) {
		if (allObj.checked) {
			count++;
		}
	} else {
		for (var x = 0; x < allObj.length; x++) {
			if (allObj[x].checked) {
				count++;
			}
		}
	}
	if (count == 0) {
		alert("您还未选中要删除的数据！");
		return false;
	}
	return fun();
}