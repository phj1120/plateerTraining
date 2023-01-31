package org.zerock.demo.config;

import lombok.extern.log4j.Log4j2;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Log4j2
@Configuration
@MapperScan(basePackages = {"org.zerock.demo.**.mapper"})
public class RootConfig {
}
