package com.andrew.model;

/**
 * 登录结果返回
 *
 * @author andrew
 * @date 2020/1/7
 */
public enum LoginResultEnum {

    /**
     * 用户登录通过
     */
    USERPASS("/main.html","userPass"),
    /**
     * 管理员登录通过
     */
    MANAGEPASS("/managerpage/managermain.html","managerPass"),
    /**
     * 用户名错误,登录不通过
     */
    USERNAMENOTPASS("/sign_in.html","UserNotExist"),
    /**
     * 密码错误,登录不通过
     */
    PASSWORDNOTPASS("/sign_in.html","PasswordWrong");

    private String toPage;
    private String message;

    LoginResultEnum(String toPage,String message){
        this.toPage = toPage;
        this.message = message;
    }

    public String getToPage() {
        return toPage;
    }

    public String getMessage() {
        return message;
    }
}
