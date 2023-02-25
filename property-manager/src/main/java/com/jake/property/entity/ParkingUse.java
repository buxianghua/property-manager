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
 * 车位使用表
 * </p>
 *
 * @author jake-jin
 * @since 2021-03-04
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    @TableName("tb_parking_use")
@ApiModel(value="ParkingUse对象", description="车位使用表")
public class ParkingUse implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty(value = "车位使用ID")
        @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      @ApiModelProperty(value = "所属小区名称")
      private String communityName;

      @ApiModelProperty(value = "所属小区ID")
      private Integer communityId;

      @ApiModelProperty(value = "车位编号")
      private String code;

      @ApiModelProperty(value = "车牌号码")
      private String carNumber;

      @ApiModelProperty(value = "车辆牌照（照片）")
      private String picture;

      @ApiModelProperty(value = "车辆所有人（业主）名称")
      private String ownerName;

      @ApiModelProperty(value = "车辆所有人（业主）ID")
      private Integer ownerId;

      @ApiModelProperty(value = "联系方式")
      private Integer telephone;

      @ApiModelProperty(value = "使用性质：0-购买(默认)，1-月租，2-年租")
      private String useType;

      @ApiModelProperty(value = "总费用(￥)，以分为单位")
      private Integer totalFee;

      @ApiModelProperty(value = "创建时间")
      private LocalDateTime createTime;

      @ApiModelProperty(value = "更新时间")
      private LocalDateTime updateTime;

      @ApiModelProperty(value = "（使用）开始时间")
      private LocalDateTime startTime;

      @ApiModelProperty(value = "（使用）结束时间")
      private LocalDateTime endTime;


}
