package com.zzg.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzg.entity.Order;
import com.zzg.mapper.OrderMapper;
import com.zzg.service.OrderService;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

}
