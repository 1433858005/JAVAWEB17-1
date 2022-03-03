package com.example.spring001;

import com.example.spring001.dao.UserDao;

public class userimpl implements user{
 //非引用类型
    private int num;
    public void setNum(int num) {
        this.num = num;
    }
    private String vr;

    public void setVr(String vr) {
        this.vr = vr;
    }
//****构造方法注入*************************************************************************

public  userimpl (UserDao userDao,int num ,String vr){
        this.userDao=userDao;
        this.num=num;
        this.vr=vr;
}
//*****************************************
    //引应用类型
private UserDao userDao;
    //1.对需要进行诸如的变量添加set方法
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    public void save() {
        System.out.println("执行了");
        System.out.println(num);
        System.out.println(vr);
        userDao.save();
    }

}