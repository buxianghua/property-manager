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
 * 设备表
 * </p>
 *
 * @author jake-jin
 * @since 2021-03-04
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    @TableName("tb_device")
@ApiModel(value="Device对象", description="设备表")
public class Device implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty(value = "设备ID")
        @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      @ApiModelProperty(value = "所属小区名称")
      private String communityName;

      @ApiModelProperty(value = "所属小区ID")
      private Integer communityId;

      @ApiModelProperty(value = "设备编号")
      private String code;

      @ApiModelProperty(value = "设备名称")
      private String name;

      @ApiModelProperty(value = "设备品牌")
      private String brand;

      @ApiModelProperty(value = "购买单价(￥)，单位分")
      private Integer unitPrice;

      @ApiModelProperty(value = "购买数量")
      private Integer num;

      @ApiModelProperty(value = "预计使用年限(年)")
      private Integer expectedUsefulLife;

      @ApiModelProperty(value = "创建时间")
      @TableField(fill = FieldFill.INSERT)
      private Date createTime;

      @ApiModelProperty(value = "更新时间")
      @TableField(fill = FieldFill.INSERT_UPDATE)
      private Date updateTime;


}
