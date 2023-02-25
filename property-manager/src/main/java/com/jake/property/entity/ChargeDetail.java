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
 * 收费名细表
 * </p>
 *
 * @author jake-jin
 * @since 2021-03-04
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    @TableName("tb_charge_detail")
@ApiModel(value="ChargeDetail对象", description="收费名细表")
public class ChargeDetail implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty(value = "收费明细ID")
        @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      @ApiModelProperty(value = "所属小区ID")
      private Integer communityId;

      @ApiModelProperty(value = "所属小区名称")
      private String communityName;

      @ApiModelProperty(value = "收费项目ID")
      private Integer chargeItemId;

      @ApiModelProperty(value = "收费项目名称")
      private String chargeItemName;

      @ApiModelProperty(value = "承办人名称")
      private String contractor;

      @ApiModelProperty(value = "承办人联系电话")
      private Integer telephone;

      @ApiModelProperty(value = "应收金额(￥)，单位分")
      private Integer payMoney;

      @ApiModelProperty(value = "实收金额(￥)，单位分")
      private Integer actualMoney;

      @ApiModelProperty(value = "创建时间")
      @TableField(fill = FieldFill.INSERT)
      private Date createTime;

      @ApiModelProperty(value = "缴费时间")
      @TableField(fill = FieldFill.INSERT_UPDATE)
      private Date updateTime;

      @ApiModelProperty(value = "状态：0-生效中（默认），1-已过期")
      private Integer status;


}
