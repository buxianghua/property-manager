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
 * 业主表
 * </p>
 *
 * @author jake-jin
 * @since 2021-03-04
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    @TableName("tb_owner")
@ApiModel(value="Owner对象", description="业主表")
public class Owner implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty(value = "业主ID")
        @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      @ApiModelProperty(value = "所属小区")
      private Integer communityId;

      @ApiModelProperty(value = "所属房产")
      private Integer houseId;

      @ApiModelProperty(value = "成员名称")
      private String name;

      @ApiModelProperty(value = "登录密码")
      private String password;

      @ApiModelProperty(value = "身份证号")
      private String idcard;

      @ApiModelProperty(value = "联系方式")
      private Integer telephone;

      @ApiModelProperty(value = "职业")
      private String profession;

      @ApiModelProperty(value = "性别:0-男（默认），1-女")
      private String sex;

      @ApiModelProperty(value = "类型:0-房主（默认），1-租客")
      private String type;

      @ApiModelProperty(value = "备注（默认无）")
      private String remark;

      @ApiModelProperty(value = "创建时间")
      @TableField(fill = FieldFill.INSERT)
      private Date createTime;

      @ApiModelProperty(value = "更新时间")
      @TableField(fill = FieldFill.INSERT_UPDATE)
      private Date updateTime;

      @ApiModelProperty(value = "年龄")
      private Integer old;


}
