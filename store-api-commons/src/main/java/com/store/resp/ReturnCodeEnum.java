package com.store.resp;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum ReturnCodeEnum
{
    /**operation failed**/
    RC999("999","operation failed"),
    /**Successful operation**/
    RC200("200","success"),
    /**Service downgrade**/
    RC201("201","Service downgrade protection is enabled, please try again later!"),
    /**Hotspot parameter current limit**/
    RC202("202","Hotspot parameter current limit, please try again later!"),
    /**System rules are not met**/
    RC203("203","The system rules do not meet the requirements, please try again later!"),
    /**Authorization rules failed**/
    RC204("204","Authorization rules failed, please try again later!"),
    /**access_denied**/
    RC403("403","No access rights, please contact the administrator to grant permissions"),
    /**access_denied**/
    RC401("401","Exceptions when anonymous users access resources without permission"),
    RC404("404","404 page not found exception"),
    /**服务异常**/
    RC500("500","System exception, please try again later"),
    RC375("375","Mathematical operation exception, please try again later"),

    INVALID_TOKEN("2001","Access token is invalid"),
    ACCESS_DENIED("2003","No permission to access this resource"),
    CLIENT_AUTHENTICATION_FAILED("1001","Client authentication failed"),
    USERNAME_OR_PASSWORD_ERROR("1002","wrong user name or password"),
    BUSINESS_ERROR("1004","Business logic exception error"),
    UNSUPPORTED_GRANT_TYPE("1003", "Unsupported authentication mode");

    /**Custom status code**/
    private final String code;
    /**Custom description**/
    private final String message;

    ReturnCodeEnum(String code, String message){
        this.code = code;
        this.message = message;
    }

    public static ReturnCodeEnum getReturnCodeEnum(String code)
    {
        for (ReturnCodeEnum element : ReturnCodeEnum.values()) {
            if(element.getCode().equalsIgnoreCase(code))
            {
                return element;
            }
        }
        return null;
    }
    public static ReturnCodeEnum getReturnCodeEnumV2(String code)
    {
        return Arrays.stream(ReturnCodeEnum.values()).filter(x -> x.getCode().equalsIgnoreCase(code)).findFirst().orElse(null);
    }


   /* public static void main(String[] args)
    {
        System.out.println(getReturnCodeEnum("200"));
        System.out.println(getReturnCodeEnum("200").getCode());
        System.out.println(getReturnCodeEnum("200").getMessage());
        System.out.println(getReturnCodeEnumV2("404"));
        System.out.println(getReturnCodeEnumV2("404").getCode());
        System.out.println(getReturnCodeEnumV2("404").getMessage());
    }*/
}
