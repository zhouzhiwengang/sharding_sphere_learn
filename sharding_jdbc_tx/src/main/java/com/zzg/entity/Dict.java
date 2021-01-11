package com.zzg.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@TableName(value = "t_dict")
public class Dict implements Serializable {
	/**
     * 字典id
     */
    private Long dictId;
 
    /**
     * 字典类型
     */
    private String type;
 
    /**
     * 字典编码
     */
    private String code;
 
    /**
     * 字典值
     */
    private String value;

}
