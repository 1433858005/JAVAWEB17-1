package controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.Controller;

import java.lang.reflect.Type;

@Configuration
@ComponentScan(value="controller",excludeFilters =
        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class})
)
//implements WebMvcConfigurer  是为了实现其中的方法，进行静态资源的设置
public class a implements WebMvcConfigurer {
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
//        开启静态资源放行
    }
//    @RequestMapping("/save")
//    public String save(){
//        System.out.println("66666");
//        return "success.jsp";
//    }
}
