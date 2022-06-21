package com.example.majia;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

import static com.example.majia.pai.xipai;
import static com.example.majia.pai.zhengpai;

@RestController
@Service
@Controller
@ResponseBody
@CrossOrigin
public class coll {
    @Resource
    private paiMapper paimapper;
    String aa1 = "/q1";

    @RequestMapping("/q1")
    public void q1(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 1 使用request进行转发
        request.getRequestDispatcher("index.html").forward(request, response);
    }

    @RequestMapping("/q2")
    public void q2(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.getRequestDispatcher("index.html").forward(request, response);
    }

    @RequestMapping("/q3")
    public void q3(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.getRequestDispatcher("index.html").forward(request, response);
    }

    @RequestMapping("/q4")
    public void q4(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.getRequestDispatcher("index.html").forward(request, response);
    }

    //牌位控制
    @RequestMapping("/zhi")
    public String paiwei(HttpServletRequest req) throws JsonProcessingException {
        String a = req.getParameter("z");
        List<String> b = paimapper.findyi("ss");
        int c= Integer.parseInt(b.get(1));
        String re=null;
        if (a.equals("/q1")) {
            re= String.valueOf(c);
        }
        else if (a.equals("/q2")) {
            if(c!=4){
                re= String.valueOf(c+1);
            }else {
                re= String.valueOf(1);
            }
        }
        else if (a.equals("/q3")) {
            if(c!=4&c!=3){
                re= String.valueOf(c+2);
            }else {
                re= String.valueOf(c-2);
            }
        } else if (a.equals("/q4")) {
            if(c!=1){
                re= String.valueOf(c-1);
            }else {
                re= String.valueOf(4);
            }
        } else {
            System.out.println("/a出错");
        }

        return re;
    }

    //打牌
    @RequestMapping("/dp")
    public String dp(HttpServletRequest req) throws JsonProcessingException {
        String a = req.getParameter("pai");
        String id = req.getParameter("id");
        if (id.equals("/q1")) {
            extracted(a, "yi");
        } else if (id.equals("/q2")) {
            extracted(a, "er");
        } else if (id.equals("/q3")) {
            extracted(a, "sa");
        } else if (id.equals("/q4")) {
            extracted(a, "si");
        } else {
            System.out.println("/a出错");
        }


        List<String> b = paimapper.findyi("ss");
        int c= Integer.parseInt(b.get(1));
        if(c!=4){
            paimapper.xipai(String.valueOf(c+1), 2, "ss");
        }else {
            paimapper.xipai(String.valueOf(1), 2, "ss");
        }

        return a;

    }

    private void extracted(String a, String k) {
        List<String> list = paimapper.findyi(k);
        if (!Objects.equals(list.get(13), null)) {
            paimapper.xipai(list.get(13), Integer.parseInt(a) + 1, k);
            paimapper.xipai(null, 14, k);
            zhengp(paimapper.findyi(k), k);
        }
    }

    //确定庄家
    @RequestMapping("/zhuang")
    public String saveq(HttpServletRequest req) throws JsonProcessingException {
//        Random a = new Random();
//        int b = a.nextInt(3) + 1;
//        paimapper.xipai(String.valueOf(b), 2, "ss");
//        return "/q"+ String.valueOf(b);
        return "/q1";
    }


    @RequestMapping("/f")
    public String saveqf(HttpServletRequest req) throws JsonProcessingException {
        String a = req.getParameter("dz");
        List<Integer> list = paimapper.findss();
        if (list.get(0) == null) {
            paimapper.qishuqi(56);
        }
        List<Integer> list2 = paimapper.findss();
        List<String> pai = paimapper.findpai();
        String b = pai.get(list2.get(0));
        int c = list2.get(0) + 1;
        paimapper.qishuqi(c);

        if (a.equals("/q1")) {
            paimapper.xipai(b, 14, "yi");
        } else if (a.equals("/q2")) {
            paimapper.xipai(b, 14, "er");
        } else if (a.equals("/q3")) {
            paimapper.xipai(b, 14, "sa");
        } else if (a.equals("/q4")) {
            paimapper.xipai(b, 14, "si");
        } else {
            System.out.println("/a出错");
        }

        return b;
    }

    //整牌，洗牌
    @RequestMapping("/b")
    public String s1() throws JsonProcessingException {
        paimapper.shanchu();
        ArrayList<String> aa = xipai();

        for (int i = 0; i < 13; i++) {
            paimapper.tianjiapai("yi", aa.get(i));
        }
        paimapper.tianjiapai("yi", null);
        for (int i = 14; i < 27; i++) {
            paimapper.tianjiapai("er", aa.get(i));
        }
        paimapper.tianjiapai("er", null);
        for (int i = 28; i < 41; i++) {
            paimapper.tianjiapai("sa", aa.get(i));
        }
        paimapper.tianjiapai("er", null);
        for (int i = 42; i < 55; i++) {
            paimapper.tianjiapai("si", aa.get(i));
        }
        paimapper.tianjiapai("si", null);
        for (int i = 56; i < aa.size() - 14; i++) {
            paimapper.tianjiapai("pai", aa.get(i));
        }
        //发完牌后，按顺序整理牌
        zhengp(paimapper.findyi("yi"), "yi");
        zhengp(paimapper.findyi("er"), "er");
        zhengp(paimapper.findyi("sa"), "sa");
        zhengp(paimapper.findyi("si"), "si");
        for (int i = 14; i < 60; i++) {
            paimapper.xipai(null, i, "er");
            paimapper.xipai(null, i, "sa");
            paimapper.xipai(null, i, "si");
        }
        //庄家
//        Random a = new Random();
//        int b = a.nextInt(3) + 1;
        paimapper.xipai(String.valueOf(1), 2, "ss");
        return null;
    }

    private void zhengp(List<String> list, String kk) {
//        List<String> list=paimapper.findyi();
        ArrayList<String> list2 = new ArrayList<>();
        for (int j = 0; j < list.size(); j++) {
            if (!Objects.equals(list.get(j), null)) {
                list2.add(list.get(j));
            }
        }
        for (int i = 0; i < zhengpai(list2).size(); i++) {
            paimapper.xipai(zhengpai(list2).get(i), i + 1, kk);
        }
    }

    //刷新页面
    @RequestMapping("/a")
    public String save2(HttpServletRequest req) throws JsonProcessingException {
        String a = req.getParameter("dz");
        List<String> list = null;
        if (a.equals("/q1")) {
            list = paimapper.findyi("yi");
        } else if (a.equals("/q2")) {
            list = paimapper.findyi("er");
        } else if (a.equals("/q3")) {
            list = paimapper.findyi("sa");
        } else if (a.equals("/q4")) {
            list = paimapper.findyi("si");
        } else {
            System.out.println("/a出错");
        }

        List<String> list2 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (!Objects.equals(list.get(i), null)) {
                list2.add(list.get(i));
                System.out.println(list.get(i));
            }
        }

        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(zhengpai(list2));
    }

    @RequestMapping("/pai")
    public String fapai() throws JsonProcessingException {
        List<Integer> list = paimapper.findss();
        if (list.get(0) == null) {
            paimapper.qishuqi(56);
        }
        System.out.println(list);
        return "null";
    }


}
