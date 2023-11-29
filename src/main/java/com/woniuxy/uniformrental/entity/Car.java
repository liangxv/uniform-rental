package com.woniuxy.uniformrental.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;

/**
 * (Car)表实体类
 *
 * @author makejava
 * @since 2023-11-27 10:22:30
 */
@SuppressWarnings("serial")
@Data
public class Car extends Model<Car> {

    private Long id;
    //车辆类型
    private Integer carTypeId;
    //车牌号
    private String carNumber;
    //车架号
    private String frameNumber;
    //电机号
    private String motorNumber;
    //上牌日期
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date dateRegistration;
    //车辆状态 1：闲置、0：租赁
    private Integer state;
    //用途
    private String carUse;
    //备注
    private String remarks;

    @TableLogic  //这是逻辑删除字段
    private Integer deleted;


}

