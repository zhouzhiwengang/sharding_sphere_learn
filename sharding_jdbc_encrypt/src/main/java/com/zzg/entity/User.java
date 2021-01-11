package com.zzg.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@SuppressWarnings("serial")
@TableName(value = "t_user")
@Data
public class User implements Serializable {
	 /**
     * 用户id
     */
    private Long id;
 
    /**
     * 用户姓名
     */
    private String userName;
 
    /**
     * 用户密码
     */
    private String password;

}
