package com.zzg.common.controller;

import java.util.Map;


import com.zzg.common.entity.PageParame;


public abstract class AbstractController<T> {
	public static final String PAGE = "page";
	
	public static final String LIMIT = "limit";
	
	/**
	 * 参数分页参数转换校验
	 * 
	 * @param param
	 * @return
	 */
	protected PageParame initPageBounds(Map<String, Object> param) {
		int page = param.get(PAGE) != null ? Integer.valueOf(param.get(PAGE).toString()) : 1 ;
		int limit = param.get(LIMIT) != null ? Integer.valueOf(param.get(LIMIT).toString()) : 10 ;
		// 页码和页数取消最大限制
		page = (page <= 0) ? 1 : page;
		limit = (limit <= 0) ? 10 : limit;
		return new PageParame(page, limit);
	}
}
