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
 * 投诉表
 * </p>
 *
 * @author jake-jin
 * @since 2021-03-04
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    @TableName("tb_complaint")
@ApiModel(value="Complaint对象", description="投诉表")
public class Complaint implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty(value = "投诉ID")
        @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      @ApiModelProperty(value = "所属小区名称")
      private String communityName;

      @ApiModelProperty(value = "所属小区ID")
      private Integer communityId;

      @ApiModelProperty(value = "投诉人员（业主）ID")
      private Integer ownerId;

      @ApiModelProperty(value = "投诉人员（业主）名称")
      private String ownerName;

      @ApiModelProperty(value = "投诉具体描述")
      private String description;

      @ApiModelProperty(value = "投诉事由")
      private String reason;

      @ApiModelProperty(value = "创建时间")
      private LocalDateTime createTime;

      @ApiModelProperty(value = "更新时间")
      private LocalDateTime updateTime;

      @ApiModelProperty(value = "状态：0-未受理，1-已受理（默认），2-已处理完毕")
      private String status;


}
