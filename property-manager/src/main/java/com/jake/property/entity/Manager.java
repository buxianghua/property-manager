package com.jake.property.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 物业管理人员表
 * </p>
 *
 * @author jake-jin
 * @since 2021-03-04
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    @TableName("tb_manager")
@ApiModel(value="EstateManager对象", description="物业管理人员表")
public class Manager implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty(value = "物业管理人员ID")
        @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      @ApiModelProperty(value = "所属小区名称")
      private String communityName;

      @ApiModelProperty(value = "所属小区ID")
      private Integer communityId;

      @ApiModelProperty(value = "登录名:登录时使用的名称")
      private String loginName;

      @ApiModelProperty(value = "真实名称")
      private String name;

      @ApiModelProperty(value = "密码")
      private String password;

      @ApiModelProperty(value = "手机")
      private Integer telephone;

      @ApiModelProperty(value = "邮箱")
      private String email;

      @ApiModelProperty(value = "角色ID：0-普通用户（默认0），1-管理员用户")
      private Integer roleId;

      @ApiModelProperty(value = "创建时间")
      @TableField(fill = FieldFill.INSERT)
      private Date createTime;

      @ApiModelProperty(value = "更新时间")
      @TableField(fill = FieldFill.INSERT_UPDATE)
      private Date updateTime;


}
