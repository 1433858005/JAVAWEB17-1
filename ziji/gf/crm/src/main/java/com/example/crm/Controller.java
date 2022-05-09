package com.example.crm;


import com.sin.system.Cpu;
import com.sin.system.SystemServer;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;
import oshi.software.os.FileSystem;
import oshi.software.os.OSFileStore;
import oshi.software.os.OperatingSystem;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@org.springframework.stereotype.Controller
@ResponseBody
@CrossOrigin
public class Controller {
    @RequestMapping("/a")
    public ArrayList<Object> save() throws IllegalAccessException, UnknownHostException {
        return extracted();
    }
    @RequestMapping("/b")
    @ResponseBody
    public String save2(HttpServletRequest req)  {
        String a= req.getParameter("username");
        String b= req.getParameter("password");
        //导入权限ini文件构建权限工厂
        Factory<SecurityManager> factory = new
        IniSecurityManagerFactory("classpath:shiro.ini");
        //工厂构建安全管理器
        SecurityManager securityManager = factory.getInstance();
        //使用SecurityUtils工具生效安全管理器
        SecurityUtils.setSecurityManager(securityManager);
        //使用SecurityUtils工具获得主体
        Subject subject = SecurityUtils.getSubject();
        //构建账号token
        UsernamePasswordToken usernamePasswordToken = new
        UsernamePasswordToken(a, b);
        //登录操作
        try {
            subject.login(usernamePasswordToken);
        } catch (AuthenticationException e) {
            return "密码或账号有误";
        }
        boolean authenticated = subject.isAuthenticated();
        System.out.println(authenticated);
        return "登录成功";
    }
    private static ArrayList<Object> extracted() throws IllegalAccessException, UnknownHostException {
        ArrayList<Object> arrayList = new ArrayList<>();
        Map<String, Serializable> c =  new HashMap<String, Serializable>();
        //获取cpu对象
        Cpu cpu = SystemServer.getCpu();
        //oshi获取CPU代码
        SystemInfo systemInfo = new SystemInfo();
        CentralProcessor processor = systemInfo.getHardware().getProcessor();
        //使用setCpuInfo(processor)方法
        SystemServer s=new SystemServer();
        s.setCpuInfo(processor);
        c.put("cpu总数",cpu.getCpuNum());
        c.put("cpu利用率",cpu.getTotal());
        c.put("cpu的系统使用率",cpu.getSys());
        c.put("用户使用频率",cpu.getUsed());
        c.put("cpu的当前等待",cpu.getWait());
        c.put("cpu的空闲",cpu.getFree());
        arrayList.add(c);
//硬盘的信息
        SystemInfo si = new SystemInfo();
        OperatingSystem op = si.getOperatingSystem();
        FileSystem fileSystem = op.getFileSystem();
        OSFileStore[] fsArray = fileSystem.getFileStores().toArray(new OSFileStore[0]);
        for (OSFileStore fs : fsArray) {
            Map<String, java.io.Serializable> aa =  new HashMap<String, java.io.Serializable>();
            //获取磁盘可用空间
            long free = fs.getUsableSpace();
            //获取磁盘总容量
            long total = fs.getTotalSpace();
            //获取磁盘已用容量
            long used = total - free;
            //获取文件系统的挂载点
            String fsMount = fs.getMount();
            //文件系统类型
            String type = fs.getType();
            //系统名称
            String name = fs.getName();
            aa.put("磁盘可用空间",(int)(((free*1.0)/1024/1024/1024)));
            aa.put(" 磁盘总容量" ,(int)(((total*1.0)/1024/1024/1024)));
            aa.put("磁盘已用容量" ,(int)((used*1.0)/1024/1024/1024));
            aa.put("文件系统的挂载点" ,fsMount);
            aa.put("文件系统类型" ,type);
            aa.put("系统名称" ,name);
            arrayList.add(aa);
        }
        Map<String, java.io.Serializable> bb =  new HashMap<String, java.io.Serializable>();
        GlobalMemory memory = systemInfo.getHardware().getMemory();
        long totalByte = memory.getTotal();
        long acaliableByte = memory.getAvailable();
        bb.put( "内存总量",(int)((memory.getTotal()*1.0)/1024/1024/1024));
        bb.put("内存使用量",(int)((memory.getTotal() - memory.getAvailable()*1.0)/1024/1024/1024));
        bb.put("内存使用率",new DecimalFormat("#.##").format((totalByte-acaliableByte)*1.0/totalByte));
        InetAddress address = InetAddress.getLocalHost();
        bb.put("本机ip地址",address.getHostAddress());
        arrayList.add(bb);
        for (Object o : arrayList) {
            System.out.println(o);
        }
        return arrayList;
    }

}
