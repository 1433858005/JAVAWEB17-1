package com.sin.utils;

//import java.math.BigDecimal;
//import java.math.RoundingMode;

//import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 精确到浮点数运算
 */
public class Arith {
    /**
     * 默认除法运算精度
     */
    private static final int DEF_DIV_SCALE = 10;
    /**
     * 这个类无法实例化
     */
    private Arith(){

    }

    /**
     * 提供精确的加法运算
     * @param d1 被加数
     * @param d2 加数
     * @return 两个参数的和
     */
    public static double add(double d1, double d2){
        BigDecimal b1= new BigDecimal(Double.toString(d1));
        BigDecimal b2= new BigDecimal(Double.toString(d2));
        return b1.add(b2).doubleValue();
    }

    /**
     * 提供精确的减法运算
     * @param d1 被减数
     * @param d2 减数
     * @return 两个减数的差
     */
    public static double sub(double d1, double d2){
        BigDecimal b1= new BigDecimal(Double.toString(d1));
        BigDecimal b2= new BigDecimal(Double.toString(d2));
        return b1.subtract(b2).doubleValue();
    }

    /**
     * 提供精确的乘法运算
     * @param d1 被乘数
     * @param d2 乘数
     * @return 两个参数的积
     */
    public  static double mul(double d1, double d2) {
//        System.out.println(d1);
//        System.out.println(d2);
        BigDecimal b1 = new BigDecimal(Double.toString(d1));
        BigDecimal b2 = new BigDecimal(Double.toString(d2));
        return b1.multiply(b2).doubleValue();
//        return d1*d2;
    }

    /**
     * 提供精确的除法运算，当发生除不尽的情况下，精确到10位，10位之后四舍五入
     *
     * @param v 精确到10
     * @param d1 被除数
     * @param d2 除数
     * @return  两个参数的商
     */
    public static double div(double v, double d1, double d2) throws Exception {
        return div(d1,d2,DEF_DIV_SCALE);
    }

    /**
     * 提供精确的出发与运算，当发生除不尽的时候，有scale指定精度，以后的数字四舍五入
     * @param d1 被除数
     * @param d2 除数
     * @param scale 表示需要精确到小数以后几位
     * @return
     */
    public static double div(double d1,double d2,int scale) throws Exception {
        if(scale<0) {
            throw  new Exception("这里有错");
        }
        BigDecimal b1 = new BigDecimal(Double.toString(d1));
        BigDecimal b2 = new BigDecimal(Double.toString(d2));
        if(b1.compareTo(BigDecimal.ZERO) == 0){
            return BigDecimal.ZERO.doubleValue();
        }
        return b1.divide(b2,scale, RoundingMode.HALF_UP).doubleValue();
    }

    /**
     * 提供精确小数四舍五入的处理
     * @param mul  需要四舍五入的数字
     * @param i 小数点后保留几位
     * @return
     */
    public static double round(double mul, int i) throws IllegalAccessException {
        if (i<0){
            throw new IllegalAccessException("小数点后有错");
        }
        BigDecimal bigDecimal = new BigDecimal(Double.toString(mul));
        BigDecimal bigDecimal1 = new BigDecimal("1");
        return bigDecimal.divide(bigDecimal1,i,RoundingMode.HALF_UP).doubleValue();
    }
}