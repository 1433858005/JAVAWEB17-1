package com.sin.system;

import com.sin.utils.Arith;

// cpu相关信息
public class Cpu {
    //核心数
    private int cpuNum;
    //cpu总使用
    private double total;
    //cpu的系统使用
    private double sys;
    //cpu的用户使用
    private double used;
    //cpu的当前等待
    private double wait;
    //cpu的空闲
    private double free;

    public int getCpuNum() {
        return cpuNum;
    }

    public void setCpuNum(int cpuNum) {
        this.cpuNum = cpuNum;
    }

    public double getTotal() throws IllegalAccessException {
        return Arith.round(Arith.mul(total,100),2);
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getSys() throws IllegalAccessException {
        /////////////////////**************************************
        return Arith.round(Arith.mul(sys / total ,100),2);

    }

    public void setSys(double sys) {
        this.sys = sys;
    }

    public double getUsed() throws IllegalAccessException {
        return Arith.round(Arith.mul(used / total ,100),2);
    }

    public void setUsed(double used) {
        this.used = used;
    }

    public double getWait() throws IllegalAccessException {
        return Arith.round(Arith.mul(wait / total ,100),2);
    }

    public void setWait(double wait) {
        this.wait = wait;
    }

    public double getFree() throws IllegalAccessException {
        return Arith.round(Arith.mul(free / total ,100),2);
    }

    public void setFree(double free) {
        this.free = free;
    }
}