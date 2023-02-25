package com.jake.property.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 宠物表
 * </p>
 *
 * @author jake-jin
 * @since 2021-03-04
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    @TableName("tb_pet")
@ApiModel(value="Pet对象", description="宠物表")
public class Pet implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty(value = "宠物ID")
        @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      @ApiModelProperty(value = "宠物照片")
      private String picture;

      @ApiModelProperty(value = "所属成员（业主）名称")
      private String ownerName;

      @ApiModelProperty(value = "所属成员（业主）ID")
      private Integer ownerId;

      @ApiModelProperty(value = "宠物名称")
      private String name;

      @ApiModelProperty(value = "宠物颜色")
      private String color;

      @ApiModelProperty(value = "备注")
      private String remark;

      @ApiModelProperty(value = "创建时间")
      private LocalDateTime createTime;

      @ApiModelProperty(value = "更新时间")
      private LocalDateTime updateTime;

      @ApiModelProperty(value = "收养时间")
      private LocalDateTime adoptTime;


}
