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
 * 信件表
 * </p>
 *
 * @author jake-jin
 * @since 2021-03-04
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    @TableName("tb_letter")
@ApiModel(value="Letter对象", description="信件表")
public class Letter implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty(value = "信件ID")
        @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      @ApiModelProperty(value = "所属小区ID")
      private Integer communityId;

      @ApiModelProperty(value = "所属小区名称")
      private String communityName;

      @ApiModelProperty(value = "信件发送者（业主）ID")
      private Integer ownerId;

      @ApiModelProperty(value = "信件发送者（业主）名称")
      private String ownerName;

      @ApiModelProperty(value = "信件来源：0-信箱（默认），1-邮件，2-微信，3-公众号，4-app,5-pc")
      private String origin;

      @ApiModelProperty(value = "信件标题")
      private String title;

      @ApiModelProperty(value = "信箱内容")
      private String content;

      @ApiModelProperty(value = "创建时间")
      private LocalDateTime createTime;

      @ApiModelProperty(value = "更新时间")
      private LocalDateTime updateTime;

      @ApiModelProperty(value = "状态:0-未读（默认），1-已读")
      private String status;


}
