import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class t {
    public static void main(String[] args) throws IOException {
        //创建HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
//声明访问地址，声明httpGET请求对象
        HttpGet httpGet = new HttpGet("https://www.autohome.com.cn/bestauto");
//使用HttpClient发起请求，获取response
        CloseableHttpResponse response = httpClient.execute(httpGet);
//判响应状态码是否为200
        if (response.getStatusLine().getStatusCode()==200){
            String s = EntityUtils.toString(response.getEntity(),"UTF-8");
            System.out.println(s);
        }
    }
}
