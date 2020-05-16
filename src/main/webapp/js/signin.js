$(function () {

    showErrorMessage();
    showSignupSuccess();
    otherlogin();
});

function getParam(name) {
    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if(r!=null){
        return unescape(r[2]);
    }
    return null;
}

function showErrorMessage() {
    var param=getParam("error");
    var userNotExist=$("#userNotExist");
    var passwordWrong=$("#passwordWrong");
    userNotExist.css("color","red");
    passwordWrong.css("color","red");
    if(param==null){
        return;
    }else if(param=="UserNotExist"){
        userNotExist.html("用户不存在");
    }else if(param=="PasswordWrong"){
        passwordWrong.html("密码错误");
    }
}

function  showSignupSuccess() {
    var param=getParam("signup");
    if(param==null){
        return;
    }else{
        alert("注册成功");
    }
}

function otherlogin() {
    var param=getParam("otherLogin");
    if(param==null){
        return;
    }else{
        alert("账号在其他地方登录");
    }

}