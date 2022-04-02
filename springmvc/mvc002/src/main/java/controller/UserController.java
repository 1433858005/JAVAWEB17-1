package controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import java.util.ArrayList;
import java.util.List;

@Controller
//@RequestMapping("/s")
public class UserController {

    @RequestMapping("/q")
    public ModelAndView save(ModelAndView modelAndView) {
        modelAndView.addObject("name","zhangsan");
       modelAndView.setViewName("s.jsp");
        System.out.println("66666");
        return modelAndView;
    }

    @RequestMapping("/w")
    @ResponseBody
    public List se() {
        System.out.println("66666");
        ArrayList a=new ArrayList();
        a.add("张三"+":23");
        a.add("lisi");
        a.add("王五：25");
        return a;
    }

//    http://localhost/save
    @RequestMapping("/b")
    public void save1() {
        System.out.println("66666");
//        return "redirect:/s.jsp";
    }
//    http://localhost/s.jsp

    //普通类型参数
//    http://localhost/a?name=kk
    @RequestMapping ("/a")
    public String requestParam (String name){
        System.out.println ("name="+name);
        return "s.jsp";
    }
    @RequestMapping ("/aa")
//规定传参形式为nameaa，required = true 设置nameaa必须要有参数 设置默认值为999 defaultValue = ("999")
    //http://localhost/aa?nameaa=6666
    public String aa (@RequestParam(value = "nameaa",required = true ,defaultValue = ("999")) String name){
        System.out.println ("name="+name);
        return "s.jsp";
    }
}