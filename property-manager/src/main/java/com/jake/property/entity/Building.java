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
 * 楼栋表
 * </p>
 *
 * @author jake-jin
 * @since 2021-03-04
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    @TableName("tb_building")
@ApiModel(value="Building对象", description="楼栋表")
public class Building implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty(value = "楼栋ID")
        @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      @ApiModelProperty(value = "所属小区名称")
      private String communityName;

      @ApiModelProperty(value = "所属小区ID")
      private Integer communityId;

      @ApiModelProperty(value = "栋数名称")
      private String name;

      @ApiModelProperty(value = "总户数")
      private Integer totalHouseholds;

      @ApiModelProperty(value = "描述")
      private String description;

      @ApiModelProperty(value = "创建时间")
      @TableField(fill = FieldFill.INSERT)
      private Date createTime;

      @ApiModelProperty(value = "更新时间")
      @TableField(fill = FieldFill.INSERT_UPDATE)
      private Date updateTime;


}
