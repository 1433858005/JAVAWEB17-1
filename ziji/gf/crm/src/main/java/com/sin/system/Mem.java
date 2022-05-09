package com.sin.system;

import com.sin.utils.Arith;

/**
 * 内存相关信息
 */
public class Mem {
    /**
     * 内存总量
     */
    private double total;
    /**
     * 已用内存
     */
    private double used;
    /**
     * 剩余内存
     */
    private double free;


    public double getTotal() throws Exception {
        return Arith.div(total,(1024 * 1024 *1024),2);
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getUsed() throws Exception {
        return Arith.div(used,(1024 * 1024 *1024),2);
    }

    public void setUsed(double used) {
        this.used = used;
    }

    public double getFree() throws Exception {
        return Arith.div(free,(1024 * 1024 *1024),2);
    }

    public void setFree(double free) {
        this.free = free;
    }


    public double getUsage() throws Exception {
        return Arith.mul(Arith.div(used,total,4),100);
    }
}