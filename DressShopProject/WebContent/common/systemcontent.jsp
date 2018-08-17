<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>    
    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">다빈도 SR 분석시스템 로그인</h3>
                    </div>
                    <div class="panel-body">
                        <form role="form" name="loginForm" method="post">
                            <fieldset>
                                <div class="form-group">
                                    <!-- <input type="email" class="form-control" id="j_username" name="j_username" placeholder="사용자 계정을 입력하십시요." autofocus> -->
                                    <input type="text" class="form-control" id="user_id" name="user_id" placeholder="사용자 계정을 입력하십시요." autofocus>
                                </div>
                                <div class="form-group">
                                    <!-- <input type="password" class="form-control" id="j_password" name="j_password" placeholder="계정 암호를 입력하십시요" > -->
                                    <input type="password" class="form-control" id="user_pw" name="user_pw" placeholder="계정 암호를 입력하십시요" >
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input name="remember" type="checkbox" value="Remember Me">Remember Me
                                    </label>
                                </div>
                                <!-- Change this to a button or input when using this as a form -->
                                <!-- <a href="index.html" class="btn btn-lg btn-success btn-block">Login</a> -->
                                <button class="btn btn-lg btn-success btn-block" onClick="fnLogin();">Login</button>
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
<script>

//var message = document.loginForm.message.value;
if ("${message}" != "") {
    vex.dialog.alert("${message}");        
}
    
function init() {
}

function fnLogin() {
	if(fnValidate()) {
	   	/* document.loginForm.action = "<c:url value='/j_spring_security_check.do'/>"; */
	   	document.loginForm.action = "<c:url value='/login/loginProc.do'/>";
	   	document.loginForm.method = "POST";
	   	document.loginForm.target = "";
	   	document.loginForm.submit();
	} else {
		return;
	}
}

function fnValidate() {
	var user_id = $("#user_id");
	var user_pw = $("#user_pw");
	
	if(user_id.val() == "" && user_pw.val() == ""){
        vex.dialog.alert("사용자 계정 및 암호를 입력하십시요.");
		return false;
	}else if(user_id.val() != "" && user_pw.val() == ""){
        vex.dialog.alert("암호를 입력하십시요.");
		return false;
	}else if(user_pw.val() != "" && user_id.val() == ""){
        /* vex.dialog.alert({
            message: "사용자 계정을 입력하십시요.",
            callback: function () {
				user_id.val().focus();
            }
        }); */
        vex.dialog.alert("사용자 계정을 입력하십시요.");
		return false;
	}
	return true;
}

</script>