package com.example.majia;

import java.util.*;


public class pai {
    public static void main(String[] args) {
//        ArrayList<String> aa=   xipai();
//     System.out.println(aa);
//        zhengpai();
    }

    //整牌
    static ArrayList<String> zhengpai(List<String> list) {
        ArrayList<String> list2 = new ArrayList<>();
        aa(list, list2, "w");
        aa(list, list2, "b");
        aa(list, list2, "t");
        bb(list, list2, "dong");
        bb(list, list2, "nan");
        bb(list, list2, "xi");
        bb(list, list2, "bei");
        bb(list, list2, "fa");
        bb(list, list2, "hong");
        bb(list, list2, "bai");
        return list2;
    }


    private static void bb(List<String> list, List<String> list2, String bb ) {
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).equals(bb)){
                list2.add(list.get(i));
            }
        }
    }


    private static void aa(List<String> list, List<String> list2,String a) {
        for (int j = 9; j > 0; j--) {
        for (int i = 0; i < list.size(); i++) {
                if(list.get(i).substring(0, 2).equals(a + String.valueOf(j))){
                    list2.add(list.get(i));
                    System.out.println(list.get(i).substring(0, 2));
                }
            }
        }
    }


    //麻将随机打乱后的牌
static ArrayList<String> xipai(){

    StringBuilder spai =new StringBuilder();
    for (int j = 0; j < 4; j++) {

    for (int i = 1; i < 10; i++) {
        spai.append("w").append(i).append(",");
    }
    for (int i = 1; i < 10; i++) {
        spai.append("t").append(i).append(",");
    }
    for (int i = 1; i < 10; i++) {
        spai.append("b").append(i).append(",");
    }
    spai.append("dong").append(",");
    spai.append("nan").append(",");
    spai.append("xi").append(",");
    spai.append("bei").append(",");
    spai.append("fa").append(",");
    spai.append("hong").append(",");
    spai.append("bai").append(",");
    }
    String pai= String.valueOf(spai);
    String[] a= pai.split(",");
    ////////////////////////////////////////////////
    ArrayList<Integer> bb=new ArrayList<>();
    for (int i = 0; i < 136; i++) {
        bb.add(i);
    }
//    System.out.println(bb);
    Random b=new Random();
    //麻将随机打乱后的牌c
    ArrayList<String> c=new ArrayList<>();
        while (c.size()!=136){
            int sj=b.nextInt(136);
            for (int i = bb.size()-1; i >= 0; i--) {
                if(sj == bb.get(i)){
                    c.add(a[bb.get(i)]);
                    bb.remove(bb.get(i));

                }
            }
        }
//    System.out.println(c);
//    System.out.println(c.size());
    return c;
}
}
