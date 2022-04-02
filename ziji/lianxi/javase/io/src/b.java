import com.sun.mail.util.BASE64EncoderStream;

import javax.xml.stream.events.StartDocument;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class b {
    public static void main(String[] args) throws IOException {
        FileOutputStream x = new FileOutputStream("C:\\Users\\14338\\Desktop\\1\\21.txt");
String a="5pyN5Yqh5ZmoDQpJUO+8mjQ5LjIzNC4xMDAuMTgyDQrlr4bnoIHvvJorSnAxNTE0OTYyMjY5Mw0KDQrmiYvmnLrlj7fvvJoxODYyODY5OTkxMg0KDQrln5/lkI3vvJpxcGFucGFuLmNvbQ0K6LSm5Y+377yaYXYwZHhzDQrlr4bnoIHvvJpaYzcpI1FrUkQyNisNCg0K5aSW572R6Z2i5p2/5Zyw5Z2AOiBodHRwOi8vNDkuMjM0LjEwMC4xODI6ODg4OC9jZTNjMzkyYw0K5YaF572R6Z2i5p2/5Zyw5Z2AOiBodHRwOi8vMTcyLjE3LjE2Ljg6ODg4OC9jZTNjMzkyYw0KdXNlcm5hbWU6IG9xYmpjanB0DQpwYXNzd29yZDogNTY5YjQ4ZDMNCg0K5pWw5o2u5bqT5ZCN77yacXBhbnBhbl9jb20NCueUqOaIt++8mnFwYW5wYW5fY29tDQrlr4bnoIHvvJpGMlRRRlBDZGlh";
        byte[] ba= Base64.getDecoder().decode(a);
        x.write(ba);
        System.out.println("原始字符串: " + new String(ba, StandardCharsets.UTF_8));


    }
}
