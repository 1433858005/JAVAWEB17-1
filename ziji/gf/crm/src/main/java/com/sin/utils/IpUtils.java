package com.sin.utils;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class IpUtils {

    public static String getIpAddr(HttpServletRequest request){
        if (request == null){
            return "unknown";
        }
        //以字符串形式返回指定请求头的值
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
            ip = request.getHeader("X-Forwarded-For");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
            ip = request.getHeader("X-Real-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
            //返回发送请求的客户机或最后一个代理的协议（ip）请求
            ip = request.getRemoteAddr();
        }
        return "0:0:0:0:0:0:0:1".equals(ip) ? "127.0.0.1" : ip;
    }



    private static boolean internalIp(byte[] addr){
        if (addr == null || addr.length < 2){
            return true;
        }
        final byte b0 = addr[0];
        final byte b1 = addr[1];
        // 10.x.x.x/8
        final byte SECTION_1 = 0X0A;
        //172.16.x.x/12
        final byte SECTION_2 = (byte) 0XAC;
        final byte SECTION_3 = (byte) 0X10;
        final byte SECTION_4 = (byte) 0X1F;
        //192.168.x.x/16
        final byte SECTION_5 = (byte) 0XC0;
        final byte SECTION_6 = (byte) 0XA8;
        switch (b0){
            case SECTION_1:
                return true;
            case SECTION_2:
                if (b1 >= SECTION_3 && b1 <= SECTION_4){
                    return true;
                }
            case SECTION_5:
                switch (b1){
                    case SECTION_6:
                        return true;
                }
            default:
                return false;
        }
    }

    /**
     * 将ipv4地址转换为字节
     * @param text
     * @return
     */
    private static byte[] textToNumericFormatV4(String text) {
        if(text.length() == 0){
            return null;
        }
        byte[] bytes = new byte[4];
        //将给定的正则表达式转为为字符串
        String[] elements = text.split("\\.",-1);
        try{
            long l;
            int i;
            switch (elements.length){
                case 1:
                    l = Long.parseLong(elements[0]);
                    if ((l< 0L) || (1 > 4294967295L)){
                        return null;
                    }
                    bytes[0] = (byte) (int) (l >> 24 & 0XFF);
                    bytes[1] = (byte) (int) ((l & 0XFFFFFF) >> 16 & 0XFF);
                    bytes[2] = (byte) (int) ((l & 0XFFFF) >> 8 & 0XFF);
                    bytes[3] = (byte) (int) (l & 0XFF);
                    break;
                case 2:
                    l = Integer.parseInt(elements[0]);
                    if ((l < 0L) || (1 > 16777215L)) {
                        return null;
                    }
                    bytes[1] = (byte) (int) (l >> 16 & 0XFF );
                    bytes[2] = (byte) (int) ((l & 0XFFFF) >> 8 & 0XFF);
                    bytes[3] = (byte) (int) (l & 0XFF);
                    break;
                case 3:
                    for (i = 0; i < 2;++i){
                        l = Integer.parseInt(elements[i]);
                        if ((l < 0l ) || (1 > 255L )){
                            return null;
                        }
                        bytes[i] = (byte) (int) (l & 0XFF);
                    }
                    l = Integer.parseInt(elements[2]);
                    if ((l < 0l ) || (l > 65535l)){
                        return null;
                    }
                    bytes[2] = (byte) (int) (l >> 8 & 0XFF);
                    bytes[3] = (byte) (int) (l & 0XFF);
                    break;
                case 4:
                    for (i = 0; i < 4;++i){
                        l = Integer.parseInt(elements[i]);
                        if((l < 0l ) || (l > 255l))
                            return null;
                        bytes[i] = (byte) (int) (l & 0XFF);
                    }
                    break;
                default:
                    return null;
            }
        }catch (Exception e){
            return null;
        }
        return bytes;
    }

    public static String getHostIp(){
        try {
            /**
             * InetAddress 这是类表示一个互联网的IP地址 ip地址分为32位或128位
             * getLocalHost（）从本机中获取地址，这是通过检索实现的从系统中获取主机名，
             * getHostAddress（） 以文本类型返回IP地址字符串
             */
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return "127.0.0.1";

    }

    public static String getHostName(){
        try {
            /**
             * InetAddress 这是类表示一个互联网的IP地址 ip地址分为32位或128位
             * getLocalHost（）从本机中获取地址，这是通过检索实现的从系统中获取主机名，
             * getHostAddress（） 以文本类型返回IP地址字符串
             */
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return "未知";
    }
}