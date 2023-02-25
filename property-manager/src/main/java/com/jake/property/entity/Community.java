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
 * 小区表
 * </p>
 *
 * @author jake-jin
 * @since 2021-03-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tb_community")
@ApiModel(value = "Community对象", description = "小区表")
public class Community implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "小区id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "小区编号")
    private String code;

    @ApiModelProperty(value = "小区名称")
    private String name;

    @ApiModelProperty(value = "坐落地址")
    private String address;

    @ApiModelProperty(value = "占地面积（m2）")
    private Double area;

    @ApiModelProperty(value = "总栋数")
    private Integer totalBuildings;

    @ApiModelProperty(value = "总户数")
    private Integer totalHouseholds;

    @ApiModelProperty(value = "绿化率（%）")
    private Integer greeningRate;

    @ApiModelProperty(value = "缩略图")
    private String thumbnail;

    @ApiModelProperty(value = "开发商名称")
    private String developer;

    @ApiModelProperty(value = "物业公司名称")
    private String estateCompany;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @ApiModelProperty(value = "状态:0-启用（默认），1-不启用")
    private Integer status;


}
