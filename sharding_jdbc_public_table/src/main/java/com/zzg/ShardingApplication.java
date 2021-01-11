package com.zzg;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zzg.mapper")
public class ShardingApplication {
	public static void main(String[] args) {
		SpringApplication.run(ShardingApplication.class, args);
		System.out.println("============= SpringBoot ShardingSphere Project Start Success =============");
	}
}
