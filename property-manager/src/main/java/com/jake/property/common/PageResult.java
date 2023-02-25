package com.jake.property.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Auth: jake-jin
 * @Desc: 分页-标准返回结果
 */
@Data   //get set
@AllArgsConstructor     //代参
@NoArgsConstructor      //无参
public class PageResult implements Serializable {

    private static final long serialVersionUID = -6250130355901431732L;

    private boolean flag;//是否成功
    private Integer code;//返回码
    private String message;//返回消息
    private Object data;
    private Long total;

}
