import com.sun.mail.util.BASE64DecoderStream;

import java.io.*;

public class a {
    public static void main(String[] args) throws IOException {
        FileOutputStream x = new FileOutputStream("C:\\Users\\14338\\Desktop\\1\\21.jpg");
        BASE64DecoderStream b=new BASE64DecoderStream(new FileInputStream("C:\\Users\\14338\\Desktop\\1\\a.txt"));
        int bb; //此时b是读了几个字节
        byte[] q=new byte[1024];
        while ((bb=b.read(q))!=-1){
            System.out.println(bb);
            x.write(q,0,bb);
        }
        x.close();
        b.close();
    }
}
