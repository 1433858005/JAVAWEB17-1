package com.sin.utils;


import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md2Hash;
import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * shiro工具类
 */
public class ShiroUtils {
    /**
     * 使用原生密码+盐，通过md5加密生成密码
     * @param password 原生密码
     * @param credentialseSalt 加强盐（username+salt）
     * @return
     */
    public static String encryptPassword(String password ,String credentialseSalt){
        return new Md5Hash(password,credentialseSalt,2).toHex().toString();
    }

    /**
     * 生成随机盐（插入记录的时候，可以调用）
     * @return
     */
    public static String randomsalt(){
        //一个bute占两个字节，此处生成三个字节，字符串长度为6
        SecureRandomNumberGenerator generator = new SecureRandomNumberGenerator();
        String hex = generator.nextBytes(6).toHex();
        return hex;
    }
}