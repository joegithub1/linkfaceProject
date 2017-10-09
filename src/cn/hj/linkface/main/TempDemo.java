package cn.hj.linkface.main;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import cn.hj.linkface.utils.Keys;
/**
* Title: TempDemo
* Description: 测试
* @author HuangJian
* @date 2017年10月9日
*
*/
public class TempDemo {

	public static final String api_id = "64f10bc451674af58d090e4e2effddfb"; 
    public static final String api_secret = "688b58a802664fffbb3fdbd291b10c77";
    
    
    
    public static final String filepath = "C:/handerCard.jpg";//图片路径
    public static final String POST_URL = "https://cloudapi.linkface.cn/identity/handhold_idcard_verification";

    /*{
        "request_id":"TIDb0815cfe7987469ea6f6d0a8abe6ae1f",
        "status":"OK",
        "verify_score":0.41546568274497986,
        "image_id":"3552474e8e3f44c98fc1ca5220b59ca5"
    }*/
    public static void HttpClientPost() throws ClientProtocolException, IOException {
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost post = new HttpPost(POST_URL);
        StringBody id = new StringBody(Keys.API_ID);
        StringBody secret = new StringBody(Keys.API_SECRET);
        FileBody fileBody = new FileBody(new File(filepath));
        MultipartEntity entity = new MultipartEntity();

        entity.addPart("api_id", id);
        entity.addPart("api_secret", secret);
        entity.addPart("file", fileBody);
        post.setEntity(entity);

        HttpResponse response = httpclient.execute(post);
        if (response.getStatusLine().getStatusCode() == 200) {
            HttpEntity entitys = response.getEntity();
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(entitys.getContent()));
            String line = reader.readLine();
            System.out.println(line);
        }else{
            HttpEntity r_entity = response.getEntity();
            String responseString = EntityUtils.toString(r_entity);
            System.out.println("错误码是："+response.getStatusLine().getStatusCode()+"  "+response.getStatusLine().getReasonPhrase());
            System.out.println("出错原因是："+responseString);
            //你需要根据出错的原因判断错误信息，并修改
        }

        httpclient.getConnectionManager().shutdown();
  }


	public static void main(String[] args) {
	    try {
			HttpClientPost();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
}
