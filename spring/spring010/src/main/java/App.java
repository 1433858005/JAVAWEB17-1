import com.itheima.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService= (UserService) ctx.getBean("userService");
        int ret = userService.save(666,888);
        System.out.println("app"+ret);
//        userService.delete();
    }
}