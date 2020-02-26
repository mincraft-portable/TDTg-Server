package com.minecraftportable.TDTg.base.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

//    /**
//     * 开启跨域
//     */
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        // 设置允许跨域的路由
//        registry.addMapping("/**")
//                // 设置允许跨域请求的域名
//                .allowedOrigins("*")
//                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
//                // 是否允许证书（cookies）
//                .allowCredentials(true)
//                // 设置允许的方法
//                .allowedMethods("*")
//                // 跨域允许时间
//                .maxAge(3600);
//    }

    /**
     * 开启swagger2
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/statics/**").addResourceLocations("classpath:/statics/");
        // 解决 SWAGGER 404报错
        registry.addResourceHandler("/swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

}