package com.itmuch.cloud.microservicesimpleprovideruser;

import com.itmuch.cloud.microservicesimpleprovideruser.dao.UserRepository;
import com.itmuch.cloud.microservicesimpleprovideruser.daomain.User;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.stream.Stream;

@SpringBootApplication
public class MicroserviceSimpleProviderUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceSimpleProviderUserApplication.class, args);
    }
/**
 * 初始化用户信息
 * 注：Spring Boot2不能像1.x一样，用spring.datasource.schema/data指定初始化SQL脚本，否则与actuator不能共存
 * 原因详见：
 * https://github.com/spring-projects/spring-boot/issues/13042
 * https://github.com/spring-projects/spring-boot/issues/13539
 * @param repository repo
 * @return runner
 */
   @Bean
    ApplicationRunner init(UserRepository userRepository){
        return args -> {
            User user=new User(1L,"account1","张航",20,new BigDecimal(100.00));
            User user2=new User(2L,"account1","李四",23,new BigDecimal(100.00));
            User user3=new User(3L,"account1","王五",24,new BigDecimal(100.00));
            Stream.of(user,user2,user3).forEach(userRepository::save);
        };

    }
}
