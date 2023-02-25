package com.jake.property.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Auth: jake-jin
 * @Desc: 不分页-标准返回结果
 */
@Data   //get set
@AllArgsConstructor     //代参
@NoArgsConstructor      //无参
public class Result implements Serializable {

    private static final long serialVersionUID = -2435089504958177374L;

    //是否成功
    private boolean flag;
    //返回码
    private Integer code;
    //返回消息
    private String message;
    //数据体
    private Object data;


    //自定义无参构造
    public Result(boolean b, int error, String noWritePermission) {
    }
}
