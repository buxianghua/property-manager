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
 * 房屋表
 * </p>
 *
 * @author jake-jin
 * @since 2021-03-04
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    @TableName("tb_house")
@ApiModel(value="House对象", description="房屋表")
public class House implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty(value = "房屋ID")
        @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      @ApiModelProperty(value = "所属小区名称")
      private String communityName;

      @ApiModelProperty(value = "所属小区ID")
      private Integer communityId;

      @ApiModelProperty(value = "所属栋数名称")
      private String buildingName;

      @ApiModelProperty(value = "所属栋数ID")
      private Integer buildingId;

      @ApiModelProperty(value = "房产编码")
      private String code;

      @ApiModelProperty(value = "房产名称")
      private String name;

      @ApiModelProperty(value = "户主（业主）ID")
      private Integer ownerId;

      @ApiModelProperty(value = "户主（业主）名称")
      private String ownerName;

      @ApiModelProperty(value = "联系方式")
      private Integer telephone;

      @ApiModelProperty(value = "房间数")
      private Integer roomNum;

      @ApiModelProperty(value = "单元")
      private Integer unit;

      @ApiModelProperty(value = "楼层")
      private Integer floor;

      @ApiModelProperty(value = "描述")
      private String description;

      @ApiModelProperty(value = "入住时间")
      @TableField(fill = FieldFill.INSERT)
      private Date createTime;

      @ApiModelProperty(value = "变更时间")
      @TableField(fill = FieldFill.INSERT_UPDATE)
      private Date updateTime;

}
