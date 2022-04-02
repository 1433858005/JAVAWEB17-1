package ajaxceshi;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class aa {
    public static void main(String[] args) throws IOException {
        FileOutputStream aa=new FileOutputStream ( "C:\\Users\\14338\\IdeaProjects\\JAVAWEB17\\ziji\\lianxi\\javase\\io\\aa\\a.txt" ,true);
        aa.write (Integer.parseInt("6666"));
        aa.write(Integer.parseInt("sasa"));
        byte[] b={97,98,99};//创建  字节数组
        aa.write ( b );//写入
        aa.close();
    }
}
