package com.sin.system;

import com.sin.utils.Arith;
import com.sin.utils.DateUtils;
//import org.thymeleaf.util.DateUtils;

import java.lang.management.ManagementFactory;

/**
 * JVM相关信息
 */
public class Jvm {
    /**
     * 当前jvm占用的内存总数（M）
     */
    private double total;
    /**
     * jvm最大可用内存总数（M）
     */
    private double max;
    /**
     * jvm空闲内存（M）
     */
    private  double free;
    /**
     * jvm版本
     */
    private String name;
    private String version;
    /**
     * jvm 路径
     */
    private String home;

    public double getTotal() throws Exception {
        return Arith.div(total,(1024 * 1024 ),2);
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getMax() throws Exception {
        return Arith.div(max,(1024 * 1024),2);
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getFree() throws Exception {
        return Arith.div(max,(1024 * 1024),2);
    }

    public void setFree(double free) {
        this.free = free;
    }

    /**
     * 获取jdk名称
     *
     */
    public String getName(){
        return ManagementFactory.getRuntimeMXBean().getVmName();
    }

    public String getVersion() {
        return version;
    }


    public void setVersion(String version) {
        this.version = version;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }
    /**
     * jdk启动时间
     */
    public String getStratTime(){
        return DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD_HH_MM_SS, DateUtils.getServerStartDate());
    }

    /**
     * jdk运行时间
     */
    public String getRunTime(){
        return DateUtils.getDatePoor(DateUtils.getNoWDate(),DateUtils.getServerStartDate());
    }
}