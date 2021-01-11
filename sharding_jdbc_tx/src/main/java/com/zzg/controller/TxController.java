package com.zzg.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zzg.entity.Dict;
import com.zzg.entity.Order;
import com.zzg.service.DictService;
import com.zzg.service.OrderService;

import io.shardingsphere.transaction.annotation.ShardingTransactionType;
import io.shardingsphere.transaction.api.TransactionType;

@RestController
@RequestMapping("/api/tx")
public class TxController {
	@Autowired
	private DictService dictService;
	@Autowired
	private OrderService orderService;
	
	@ShardingTransactionType(value = TransactionType.XA)
    @Transactional(rollbackFor = Exception.class)
	@RequestMapping(value = "/insert", method = { RequestMethod.GET })
	public Object batchInsert() {

		
			Dict dict = new Dict();
			dict.setDictId(Long.valueOf(1));
			dict.setCode("code=1");
			dict.setType("type=1");
			dict.setValue("value=1");
			dictService.save(dict);
			
			// 异常信息
			int num = 1 / 0;
			
			Order order = new Order();
			order.setOrderId(Long.valueOf(1));
	        order.setPrice(BigDecimal.valueOf(0.1));
	        order.setStatus("0");
	        order.setUserId(Long.valueOf("" + 1));
	        orderService.save(order);
			
			
		

		return "批量新增成功";
	}

}
