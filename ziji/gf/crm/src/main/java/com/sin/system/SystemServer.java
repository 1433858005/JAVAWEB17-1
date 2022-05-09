package com.sin.system;



//import ch.qos.logback.core.util.SystemInfo;
import com.sin.utils.Arith;
import com.sin.utils.IpUtils;
//import com.sun.java.browser.plugin2.liveconnect.v1.InvocationDelegate;

//import  com.sun.java.browser.*;
//import oshi.SystemInfo;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HardwareAbstractionLayer;
//import oshi.software.os.FileSystem;

import oshi.software.os.FileSystem;
import oshi.software.os.OSFileStore;
import oshi.util.Util;

import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

/**
 * 服务器的相关信息
 */
public class SystemServer {

    private static final int OSHT_WAIT_SECOND = 1000;

    /**
     * cpu相关信息
     */
    private static Cpu cpu =new Cpu();
    /**
     * 内存相关信息
     */
    private static Mem mem = new Mem();
    /**
     * jvm相关信息
     */
    private Jvm jvm = new Jvm();
    /**
     * 服务器相关信息
     */
    private Sys sys = new Sys();
    /**
     * 磁盘信息
     */

    private static  List<Sysfile> sysfiles = new LinkedList<Sysfile>();

    public static Cpu getCpu() {
        return cpu;
    }

    public void setCpu(Cpu cpu) {
        SystemServer.cpu = cpu;
    }

    public Mem getMem() {
        return mem;
    }

    public void setMem(Mem mem) {
        this.mem = mem;
    }

    public Jvm getJvm() {
        return jvm;
    }

    public void setJvm(Jvm jvm) {
        this.jvm = jvm;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public static List<Sysfile> getSysfiles() {
        return sysfiles;
    }

//    public void setSysfiles(List<Sysfile> sysfiles) {
//        this.sysfiles = sysfiles;
//    }
//    public void setSysfiles(OperatingSystem operatingSystem) {
////        this.sysfiles = operatingSystem;
//    }
    public void setSysfiles() throws Exception {
//        this.sysfiles = operatingSystem;
        setSysFiles();
    }
    public void copyTo(){
//        SystemInfo systemInfo =  new SystemInfo();
        SystemInfo systemInfo =  new SystemInfo();
//        HardwareAbstractionLayer layer = systemInfo.getHardware();
        HardwareAbstractionLayer layer = systemInfo.getHardware();
    }

    /**
     * 设置CPU信息
     */
    public void setCpuInfo(CentralProcessor processor){
        //cpu信息
        long[] prevTicks = processor.getSystemCpuLoadTicks();
        Util.sleep(OSHT_WAIT_SECOND);
        long[] ticks = processor.getSystemCpuLoadTicks();
        long nice = ticks[CentralProcessor.TickType.NICE.getIndex()] - prevTicks[CentralProcessor.TickType.NICE.getIndex()];
        long irq = ticks[CentralProcessor.TickType.IRQ.getIndex()] - prevTicks[CentralProcessor.TickType.IRQ.getIndex()];
        long softirq = ticks[CentralProcessor.TickType.SOFTIRQ.getIndex()] - prevTicks[CentralProcessor.TickType.SOFTIRQ.getIndex()];
        long steal = ticks[CentralProcessor.TickType.STEAL.getIndex()]-prevTicks[CentralProcessor.TickType.STEAL.getIndex()];
        long cSys = ticks[CentralProcessor.TickType.SYSTEM.getIndex()] - prevTicks[CentralProcessor.TickType.SYSTEM.getIndex()];
        long user = ticks[CentralProcessor.TickType.USER.getIndex()] - prevTicks[CentralProcessor.TickType.USER.getIndex()];
        long iowait = ticks[CentralProcessor.TickType.IOWAIT.getIndex()] - prevTicks[CentralProcessor.TickType.IOWAIT.getIndex()];
        long idle = ticks[CentralProcessor.TickType.IDLE.getIndex()] - prevTicks[CentralProcessor.TickType.IDLE.getIndex()];
        long totalCpu=user + nice + cSys + idle + iowait + irq + softirq + steal;

        cpu.setCpuNum(processor.getLogicalProcessorCount());
        cpu.setTotal(totalCpu);
        cpu.setSys(cSys);
        cpu.setUsed(user);
        cpu.setWait(iowait);
        cpu.setFree(idle);

    }

    /**
     * 设置内存信息
     */
    private static void  setMemInfo(GlobalMemory memory){
        mem.setTotal(memory.getTotal());
        mem.setUsed(memory.getTotal() - memory.getAvailable());
        mem.setFree(memory.getAvailable());
    }
    /**
     * 设置服务器信息
     */
    private  void setSysInfo(){
        Properties properties = System.getProperties();
        sys.setComputerName(IpUtils.getHostName());
        sys.setComputerName(IpUtils.getHostIp());
        sys.setOsName(properties.getProperty("os.name"));
        sys.setOsArch(properties.getProperty("os.arch"));
        sys.setUserDir(properties.getProperty("user.dir"));
    }
    /**
     * 设置Java虚拟机
     */
    private void setJvmInfo() {
        //获取当前系统的属性
        Properties properties = System.getProperties();
        //获取运行时间
        //返回Java虚拟机中的内存总量
        jvm.setTotal(Runtime.getRuntime().totalMemory());
        //返回Java虚拟机中的空闲内存量
        jvm.setFree(Runtime.getRuntime().freeMemory());
        //返回Java虚拟机将使用的最大内存量
        jvm.setMax(Runtime.getRuntime().maxMemory());

        jvm.setVersion(properties.getProperty("java.version"));
        jvm.setHome(properties.getProperty("java.home"));
    }


//     设置磁盘信息
    private Sysfile setSysFiles() throws Exception {
        SystemInfo si = new SystemInfo();
        oshi.software.os.OperatingSystem op = si.getOperatingSystem();
//        FileSystem fileSystem = operatingSystem.getFileSystem();
        FileSystem fileSystem = op.getFileSystem();
        //获取计算机磁盘信息
        OSFileStore[] fileStores = fileSystem.getFileStores().toArray(new OSFileStore[0]);
        assert false;
        for(OSFileStore fileStore : fileStores){
            //获取磁盘可用空间
            long free = fileStore.getUsableSpace();
            //获取磁盘总容量
            long total = fileStore.getTotalSpace();
            //获取磁盘已用容量
            long used = total - free;
            Sysfile sysfile = new Sysfile();
            //获取文件系统的挂载点
            sysfile.setDirName(fileStore.getMount());
            //文件系统类型
            sysfile.setSysTypeName(fileStore.getType());
            //系统名称
            sysfile.setTypeName(fileStore.getName());
            //磁盘总容量
            sysfile.setTotal(convertFileSize(total));
            //磁盘可用空间
            sysfile.setFree(convertFileSize(free));
            //磁盘已用容量
            sysfile.setUsed(convertFileSize(used));
            //计算出资源使用
            sysfile.setUsage(Arith.mul(Arith.div(used,total,4),100));
            return sysfile;
        }

        return null;
    }

    /**
     * 字节的转换
     * @param size
     * @return
     */
    private String convertFileSize(long size) {
        long kb = 1024;
        long mb = kb * 1024;
        long gb = mb * 1024;

        if (size >= gb ){
            //使用指定的格式字符串和参数返回格式化字符串。
            return String.format("%.1f GB",(float) size/gb);
        }else if(size >= mb){
            float f = (float) size / mb;
            return String.format(f > 100 ? "%.0f MB":"%.1f MB",f);
        }else if (size >= kb){
            float f = (float) size / kb;
            return String.format(f > 100 ? "%.0f KB" : "%.1f KB",f);
        } else {
            return String.format("%d B",size);
        }
    }

}