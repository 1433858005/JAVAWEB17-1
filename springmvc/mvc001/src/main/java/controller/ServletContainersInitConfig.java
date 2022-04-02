package controller;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.EnumSet;

public class ServletContainersInitConfig extends AbstractDispatcherServletInitializer {

    @Override
    protected WebApplicationContext createServletApplicationContext() {

        AnnotationConfigWebApplicationContext ctx=new AnnotationConfigWebApplicationContext();
        ctx.register(a.class);//为谁配置
        return ctx;
        //此处替代的web.xml中的内容是
//         <servlet>
//        <servlet-name>DispatcherServlet</servlet-name>
//<!--        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>-->
//        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
//        <init-param>
//            <param-name>contextConfigLocation</param-name>
//            <param-value>classpath*:spring-mvc. xml</param-value>
//        </init-param>
//    </servlet>
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
//         <servlet-mapping>
//        <servlet-name>DispatcherServlet</servlet-name>
//        <url-pattern>/</url-pattern>
//    </servlet-mapping>
    }

    @Override
    protected WebApplicationContext createRootApplicationContext() {
        return null;
    }
    //上面这三个方法，就是mvc配置的基本需求了，下面的是添加web.xml里没有添加的

//    @Override
//    public void onStartup(ServletContext servletContext) throws ServletException {
//        super.onStartup(servletContext);
//        CharacterEncodingFilter cef=new CharacterEncodingFilter();
//        cef.setEncoding("UTF-8");
//        FilterRegistration.Dynamic registration = servletContext.addFilter(" characterEncodingFilter", cef);
//        registration.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST,DispatcherType.FORWARD,DispatcherType.INCLUDE),false,"/*");
////<!--    中文乱码处理-->
////    <filter>
////        <filter-name>characterEncodingFilter</filter-name>
////        <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
////        <init-param>
////            <param-name>encoding</param-name>
////            <param-value>UTF-8</param-value>
////        </init-param>
////    </filter>
////
////    <filter-mapping>
////        <filter-name>characterEncodingFilter</filter-name>
////        <url-pattern>/*</url-pattern>
////    </filter-mapping>
//    }
}
