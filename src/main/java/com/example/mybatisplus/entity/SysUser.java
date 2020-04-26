package com.example.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * Copyright (C), 2016-2019, Mobius-Vision .
 * FileName: SysUser
 * Author: liuwenxu
 * Date: 2019-12-20 16:21:56
 * Description:  实体类
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_user")
@ApiModel(value="SysUser对象", description="")
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String username;

    @ApiModelProperty(value = "登录密码")
    private String password;

    @ApiModelProperty(value = "昵称")
    private String nickname;

    @ApiModelProperty(value = "手机号")
    private String mobile;

    @ApiModelProperty(value = "邮箱地址")
    private String email;

    @ApiModelProperty(value = "QQ")
    private String qq;

    @ApiModelProperty(value = "生日")
    private LocalDate birthday;

    @ApiModelProperty(value = "性别")
    private Integer gender;

    @ApiModelProperty(value = "头像地址")
    private String avatar;

    @ApiModelProperty(value = "超级管理员、管理员、普通用户")
    private String userType;

    @ApiModelProperty(value = "注册IP")
    private String regIp;

    @ApiModelProperty(value = "最近登录IP")
    private String lastLoginIp;

    @ApiModelProperty(value = "最近登录时间")
    private LocalDateTime lastLoginTime;

    @ApiModelProperty(value = "登录次数")
    private Integer loginCount;

    @ApiModelProperty(value = "用户备注")
    private String remark;

    @ApiModelProperty(value = "用户状态")
    private Integer status;

    @ApiModelProperty(value = "注册时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;


}
