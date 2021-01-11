package com.zzg.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzg.common.controller.AbstractController;
import com.zzg.common.entity.PageParame;
import com.zzg.entity.Order;
import com.zzg.service.OrderService;

@RestController
@RequestMapping("/api/order")
public class OrderController extends AbstractController<Order> {

	@Autowired
	private OrderService orderService;

	// 增
	@RequestMapping(value = "/insert", method = { RequestMethod.POST }, produces = "application/json;charset=UTF-8")
	public Object insert(@RequestBody Order user) {
		return orderService.save(user);
	}

	// 改
	@RequestMapping(value = "/update", method = { RequestMethod.POST }, produces = "application/json;charset=UTF-8")
	public Object update(@RequestBody Order user) {
		return orderService.updateById(user);
	}

	// 删
	@RequestMapping(value = "/delete/{id}", method = { RequestMethod.DELETE })
	public Object delete(@PathVariable("id") Integer orderId) {
		return orderService.removeById(orderId);
	}

	// 查
	@RequestMapping(value = "/getUserId", method = { RequestMethod.GET })
	public Object getUserByName(@RequestParam Integer userId) {
		QueryWrapper<Order> query = new QueryWrapper<Order>();
		query.eq("userId", userId);
		return orderService.getOne(query);
	}

	// 查
	@RequestMapping(value = "/getId", method = { RequestMethod.GET })
	public Object getId(@RequestParam Integer id) {
		return orderService.getById(id);
	}

	// 查
	@RequestMapping(value = "/getPage", method = { RequestMethod.POST })
	public Object getPage(@RequestBody Map<String, Object> parame) {
		PageParame pageParame = this.initPageBounds(parame);
		Page<Order> page = new Page<Order>(pageParame.getPage(), pageParame.getLimit());
		return orderService.page(page);
	}

	@RequestMapping(value = "/batchInsert", method = { RequestMethod.GET })
	public Object batchInsert() {
		
		for (int i = 0; i < 10; i++) {
			Order order = new Order();
			order.setPrice(new BigDecimal(Math.random()));
			order.setUserId(Long.valueOf("" + i));
			order.setStatus("0");
			
			orderService.save(order);
		}
		

		return "批量新增成功";
	}

}
