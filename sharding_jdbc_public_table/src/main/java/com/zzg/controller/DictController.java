package com.zzg.controller;

import java.math.BigDecimal;
import java.util.Map;

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
import com.zzg.entity.Dict;
import com.zzg.service.DictService;

@RestController
@RequestMapping("/api/dict")
public class DictController extends AbstractController<Dict> {
	@Autowired
	private DictService dictService;

	// 增
	@RequestMapping(value = "/insert", method = { RequestMethod.POST }, produces = "application/json;charset=UTF-8")
	public Object insert(@RequestBody Dict user) {
		return dictService.save(user);
	}

	// 改
	@RequestMapping(value = "/update", method = { RequestMethod.POST }, produces = "application/json;charset=UTF-8")
	public Object update(@RequestBody Dict user) {
		return dictService.updateById(user);
	}

	// 删
	@RequestMapping(value = "/delete/{id}", method = { RequestMethod.DELETE })
	public Object delete(@PathVariable("id") Integer DictId) {
		return dictService.removeById(DictId);
	}

	// 查
	@RequestMapping(value = "/getDictId", method = { RequestMethod.GET })
	public Object getUserByName(@RequestParam Integer userId) {
		QueryWrapper<Dict> query = new QueryWrapper<Dict>();
		query.eq("dictId", userId);
		return dictService.getOne(query);
	}

	// 查
	@RequestMapping(value = "/getId", method = { RequestMethod.GET })
	public Object getId(@RequestParam Integer id) {
		return dictService.getById(id);
	}

	// 查
	@RequestMapping(value = "/getPage", method = { RequestMethod.POST })
	public Object getPage(@RequestBody Map<String, Object> parame) {
		PageParame pageParame = this.initPageBounds(parame);
		Page<Dict> page = new Page<Dict>(pageParame.getPage(), pageParame.getLimit());
		return dictService.page(page);
	}

	@RequestMapping(value = "/batchInsert", method = { RequestMethod.GET })
	public Object batchInsert() {

		for (int i = 0; i < 10; i++) {
			Dict dict = new Dict();
			dict.setCode("code=" + i);
			dict.setType("type=" + i);
			dict.setValue("value=" + i);
			dictService.save(dict);
		}

		return "批量新增成功";
	}

}
