package com.nkpdqz.spingboot_aop_demo.configuration;

import com.nkpdqz.spingboot_aop_demo.Interceptor.MyInterceptor;
import com.nkpdqz.spingboot_aop_demo.Interceptor.UserLoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //InterceptorRegistration interceptorRegistration = registry.addInterceptor(new MyInterceptor());
        //interceptorRegistration.addPathPatterns("/**");
        InterceptorRegistration interceptorRegistration1 = registry.addInterceptor(new UserLoginInterceptor());
        interceptorRegistration1.addPathPatterns("/**").excludePathPatterns("/aop/login");
        //interceptorRegistration.excludePathPatterns(                         //添加不拦截路径
        //        "你的登陆路径",            //登录
        //        "/**/*.html",            //html静态资源
        //       "/**/*.js",              //js静态资源
        //        "/**/*.css",             //css静态资源
        //        "/**/*.woff",
        //        "/**/*.ttf"
        //);
    }
}
