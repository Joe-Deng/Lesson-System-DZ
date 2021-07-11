package com.org.config;


import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@MapperScan("com.org.mapper")
@EnableTransactionManagement
@Configuration
public class MybatisPlusConfig {
    // 注册乐观锁插件
//    @Bean   public OptimisticLockerInterceptor optimisticLockerInterceptor(){return new OptimisticLockerInterceptor();}

    //分页插件
    @Bean   public PaginationInterceptor paginationInterceptor(){return new PaginationInterceptor();}

    //逻辑删除组件
//    @Bean   public ISqlInjector sqlInjector(){return new LogicSqlInjector();}

    //SQL执行效率插件
    @Bean
    @Profile({"dev","test"})    //设置dev test环境
    public PerformanceInterceptor performanceInterceptor(){
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        performanceInterceptor.setMaxTime(100);
        performanceInterceptor.setFormat(true);
        return performanceInterceptor;
    }
}
