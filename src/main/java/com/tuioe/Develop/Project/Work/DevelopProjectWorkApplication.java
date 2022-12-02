package com.tuioe.Develop.Project.Work;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing// @CreateDate 또는 LastModifiedDate로 시간 자동 생성 기능 사용시 필요
public class DevelopProjectWorkApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevelopProjectWorkApplication.class, args);
	}

}
