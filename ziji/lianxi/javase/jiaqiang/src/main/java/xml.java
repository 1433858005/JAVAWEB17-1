import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

public class xml {
    public static void main(String[] args) throws DocumentException {
       //1.获取一个解析器对象
        SAXReader saxReader = new SAXReader();
        //2.利用解析器对象把xml文件加载到内存中，并返回一个文档对象
        Document document = saxReader.read(new File("ziji/lianxi/javase/jiaqiang/src/main/webapp/WEB-INF/web.xml"));
       //3.获取到根标签
        Element rootElement = document.getRootElement();
        //4.通过根标签来获取到student标签
        //element()可以获取调用者所有的子标签，会把这些子标签放到一个集合中返回
        //element("标签名")；可以获取到所有指定的子标签，会把这些子标签放到一个集合中返回
//        List list = rootElement.elements();  获取所有的子标签
//        System.out.println(list.size());
        List<Element> student = rootElement.elements("student");
//        System.out.println(student.size());   //student子标签个数
//        5.遍历集合，得到每一个student标签
        for (Element element : student) {
            //element表示每一个student标签
            //获取ID这个属性
            Attribute id = element.attribute("id");
            //获取id的属性值
            String idValue = id.getValue();
             //获取name标签
//            element("标签名")：获取调用者指定的子标签
            Element elementname= element.element("name");
            //获取这个子标签的标签的标签内容
            String name = elementname.getText();

            Element elementage = element.element("age");
            String age = elementage.getText();
            System.out.println(idValue);
            System.out.println(name);
            System.out.println(age);
        }

    }
}
