package controller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import daomain.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import service.StudentService;
import service.StudentServiceImpl;
import java.sql.SQLException;
import java.util.ArrayList;
@Controller
public class c  {
    StudentService service=new StudentServiceImpl();
    ObjectMapper mapper=  new ObjectMapper();
    @RequestMapping("/q")
    @ResponseBody
    public ModelAndView save(ModelAndView modelAndView) throws SQLException, JsonProcessingException {
        ArrayList<Student> list = service.findAll();
        modelAndView.addObject("list",list);
        modelAndView.setViewName("s.jsp");
        return modelAndView;

    }
}
