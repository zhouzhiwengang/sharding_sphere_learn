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
import com.zzg.entity.User;
import com.zzg.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController extends AbstractController<User> {
	@Autowired
	private UserService userService;
	
	// 增
		@RequestMapping(value = "/insert", method = { RequestMethod.POST }, produces = "application/json;charset=UTF-8")
		public Object insert(@RequestBody User user) {
			return userService.save(user);
		}

		// 改
		@RequestMapping(value = "/update", method = { RequestMethod.POST }, produces = "application/json;charset=UTF-8")
		public Object update(@RequestBody User user) {
			return userService.updateById(user);
		}

		// 删
		@RequestMapping(value = "/delete/{id}", method = { RequestMethod.DELETE })
		public Object delete(@PathVariable("id") Integer UserId) {
			return userService.removeById(UserId);
		}

		// 查
		@RequestMapping(value = "/getUserId", method = { RequestMethod.GET })
		public Object getUserByName(@RequestParam Integer userId) {
			QueryWrapper<User> query = new QueryWrapper<User>();
			query.eq("userId", userId);
			return userService.getOne(query);
		}

		// 查
		@RequestMapping(value = "/getId", method = { RequestMethod.GET })
		public Object getId(@RequestParam Integer id) {
			return userService.getById(id);
		}

		// 查
		@RequestMapping(value = "/getPage", method = { RequestMethod.POST })
		public Object getPage(@RequestBody Map<String, Object> parame) {
			PageParame pageParame = this.initPageBounds(parame);
			Page<User> page = new Page<User>(pageParame.getPage(), pageParame.getLimit());
			return userService.page(page);
		}

		@RequestMapping(value = "/batchInsert", method = { RequestMethod.GET })
		public Object batchInsert() {
			
			for (int i = 0; i < 10; i++) {
				User user = new User();
				user.setId(Long.valueOf(""+i));
				user.setUserName("name = " + i);
				user.setPassword(""+i);
				userService.save(user);
			}
			

			return "批量新增成功";
		}

}
