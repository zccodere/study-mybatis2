package com.zccoder.mybatis2.ch10.boot;

import com.zccoder.mybatis2.ch10.boot.mapper.CountryMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * 标题：启动类<br>
 * 描述：启动类<br>
 * 时间：2018/06/28<br>
 *
 * @author zc
 **/
@SpringBootApplication
@MapperScan(basePackages = {"com.zccoder.mybatis2.ch10.boot.mapper", "com.zccoder.mybatis2.ch2.xml.mapper"}, nameGenerator = MapperNameGenerator.class)
public class BootApplication extends SpringBootServletInitializer implements CommandLineRunner {

    @Autowired
    private CountryMapper countryMapper;

    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(BootApplication.class);
    }

    /**
     * Spring Boot项目启动完成后自动执行
     *
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        System.out.println(countryMapper.listAll());
    }
}
