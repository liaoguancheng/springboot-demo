package com.zhss.springboot.config;

import com.zhss.springboot.interceptor.UserLoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.*;

import java.util.List;

@Configuration
public class MvcConfigurer implements WebMvcConfigurer {
    
    // 拦截器
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new UserLoginInterceptor()).addPathPatterns("/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry resourceHandlerRegistry) {

    }

    // 跨域访问配置
    public void addCorsMappings(CorsRegistry registry) {
        /*registry.addMapping("/user/**")
            .allowedOrigins("http://www.zhss.com","http://localhost:8080/")
            .allowedMethods("POST", "GET");*/
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer pathMatchConfigurer) {

    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer contentNegotiationConfigurer) {

    }

    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer asyncSupportConfigurer) {

    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer defaultServletHandlerConfigurer) {

    }

    // 格式化
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new DateFormatter("yyyy-MM-dd HH:mm:ss"));
    }
    
    // URI到视图的映射
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/addUserUI").setViewName("/addUser.jsp");
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry viewResolverRegistry) {

    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> list) {

    }

    @Override
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> list) {

    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> list) {

    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> list) {

    }

    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> list) {

    }

    @Override
    public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> list) {

    }

    @Override
    public Validator getValidator() {
        return null;
    }

    @Override
    public MessageCodesResolver getMessageCodesResolver() {
        return null;
    }

}
