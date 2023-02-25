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
 * 车辆表
 * </p>
 *
 * @author jake-jin
 * @since 2021-03-04
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    @TableName("tb_car")
@ApiModel(value="Car对象", description="车辆表")
public class Car implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty(value = "车辆ID")
        @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      @ApiModelProperty(value = "车辆名称")
      private String carName;

      @ApiModelProperty(value = "所属成员（业主）")
      private String ownerName;

      @ApiModelProperty(value = "停车位")
      private String carSite;

      @ApiModelProperty(value = "车牌号")
      private String carNumber;

      @ApiModelProperty(value = "备注")
      private String remark;

      @ApiModelProperty(value = "创建时间")
      @TableField(fill = FieldFill.INSERT)
      private Date createTime;

      @ApiModelProperty(value = "更新时间")
      @TableField(fill = FieldFill.INSERT_UPDATE)
      private Date updateTime;


}
