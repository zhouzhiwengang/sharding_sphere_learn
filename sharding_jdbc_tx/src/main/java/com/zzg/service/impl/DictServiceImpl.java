package com.zzg.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzg.entity.Dict;
import com.zzg.mapper.DictMapper;
import com.zzg.service.DictService;

@Service
public class DictServiceImpl extends ServiceImpl<DictMapper, Dict> implements DictService {
}
