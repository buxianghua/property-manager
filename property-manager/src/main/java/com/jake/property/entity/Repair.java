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
 * 维修表
 * </p>
 *
 * @author jake-jin
 * @since 2021-03-04
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    @TableName("tb_repair")
@ApiModel(value="Repair对象", description="维修表")
public class Repair implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty(value = "维修ID")
        @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      @ApiModelProperty(value = "所属小区名称")
      private String communityName;

      @ApiModelProperty(value = "所属小区ID")
      private Integer communityId;

      @ApiModelProperty(value = "所属楼栋名称")
      private String buildingName;

      @ApiModelProperty(value = "所属楼栋ID")
      private Integer buildingId;

      @ApiModelProperty(value = "报修人员（业主）名称")
      private String ownerName;

      @ApiModelProperty(value = "报修人员（业主）ID")
      private Integer ownerId;

      @ApiModelProperty(value = "设备名称")
      private String deviceName;

      @ApiModelProperty(value = "设备编号ID")
      private Integer deviceId;

      @ApiModelProperty(value = "报修描述")
      private String description;

      @ApiModelProperty(value = "创建时间")
      @TableField(fill = FieldFill.INSERT)
      private Date createTime;

      @ApiModelProperty(value = "更新时间")
      @TableField(fill = FieldFill.INSERT_UPDATE)
      private Date updateTime;

      @ApiModelProperty(value = "状态：0-待受理，1-已受理，2-修理完毕")
      private Integer status;


}
