package com.woniuxy.uniformrental.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * 车辆类型(CarType)表实体类
 *
 * @author makejava
 * @since 2023-11-27 14:05:49
 */
@SuppressWarnings("serial")
@Data
public class CarType extends Model<CarType> implements Serializable {
    //主键ID
    private Long id;
    //类型名称
    private String typeName;
    //所属公司
    private String company;
    //备注
    private String remarks;



    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    public Serializable pkVal() {
        return this.id;
    }
}

