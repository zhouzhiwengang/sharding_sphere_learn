package com.zzg.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@TableName("t_order")
public class Order implements Serializable {
	 /**
     * 订单id
     */
    private Long orderId;
 
    /**
     * 订单价格
     */
    private BigDecimal price;
 
    /**
     * 下单用户id
     */
    private Long userId;
 
    /**
     * 订单状态
     */
    private String status;

}
