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
import java.util.Date;

/**
 * <p>
 * 活动表
 * </p>
 *
 * @author jake-jin
 * @since 2021-03-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tb_activity")
@ApiModel(value = "Activity对象", description = "活动表")
public class Activity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "活动ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "所属小区名称")
    private String communityName;

    @ApiModelProperty(value = "所属小区ID")
    private Integer communityId;

    @ApiModelProperty(value = "活动标题")
    private String title;

    @ApiModelProperty(value = "活动地点")
    private String address;

    @ApiModelProperty(value = "举办单位")
    private String organizer;

    @ApiModelProperty(value = "活动描述")
    private String description;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "活动开始时间")
    private Date startTime;

    @ApiModelProperty(value = "活动截止时间")
    private Date endTime;

    @ApiModelProperty(value = "状态:0-活动未开始（默认），1-活动进行中，2-活动已结束")
    private Integer status;


}
