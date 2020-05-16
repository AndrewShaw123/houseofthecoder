var checkUsername=false;
var checkPassword=false;
var checkPasswordConfirm=false;

$(function () {

    checkSubmit();

    $("#username").blur(function() {
        var reg=/^[\u4e00-\u9fa5\w]{1,6}$/g;
        var username=$(this).val();
        var message=$("#user-username");
        if(username==""){
            setWrongMessage(message,"用户名不能为空");
            checkUsername=false;
            return;
        }
        if(reg.test(username)){
            checkUsername=true;
            setCorrectMessage(message);
        }else{
            checkUsername=false;
            setWrongMessage(message,"用户名不规范");
            return;
        }
        $.post("validUsername",{username:username},function (data) {
            if(data.isExist==1){
                setWrongMessage(message,"用户名已经存在");
                checkUsername=false;
            }else{
                setCorrectMessage(message);
                checkUsername=true;
            }
            checkSubmit();
        },"json");
    });


    $("#password").blur(function () {
        var reg=/^[\w]{4,20}$/g;

        var password=$("#password").val();
        var passwordConfirm=$("#passwordConfirm").val();

        var message=$("#user-password");
        var message2=$("#user-passwordConfirm");

        if(!reg.test(password)){
            setWrongMessage(message,"密码不规范");
            checkPassword=false;
        }else if(passwordConfirm==password){
            setCorrectMessage(message);
            setCorrectMessage(message2);
            checkPasswordConfirm=true;
            checkPassword=true;
        }else{
            setWrongMessage(message2,"两次密码不一致");
            message.html("");
            checkPasswordConfirm=false;
            checkPassword=false;
        }
        checkSubmit();
    });

    $("#password_confirmation").blur(function () {
        var passwordConfirm=$("#password_confirmation").val();
        var password=$("#password").val();

        var message=$("#user-passwordConfirm");
        var message2=$("#user-password");

        if(passwordConfirm==""){
            setWrongMessage(message,"密码不能为空");
            checkPasswordConfirm=false;
        }else if(passwordConfirm==password){
            setCorrectMessage(message);
            setCorrectMessage(message2);
            checkPasswordConfirm=true;
            checkPassword=true;
        }else{
            setWrongMessage(message,"两次密码不一致");
            message2.html("");
            checkPasswordConfirm=false;
            checkPassword=false;
        }
        checkSubmit();
    });

});

function checkSubmit() {
    if(checkUsername==true&&checkPassword==true&&checkPasswordConfirm==true){
        $("#submit").prop("disabled",false);
    }else{
        $("#submit").prop("disabled",true);
    }
}

function setWrongMessage(messageObj,content) {
    messageObj.css("color","red");
    messageObj.html(content);
    $("#submit").prop("disabled",true);
}

function setCorrectMessage(messageObj) {
    messageObj.html("");
}