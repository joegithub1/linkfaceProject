package cn.hj.linkface.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import cn.hj.linkface.base.BaseController;
import cn.hj.linkface.utils.ConstVo;
import cn.hj.linkface.utils.HttpClientPostUtil;
import cn.hj.linkface.utils.Keys;

/**
* Title: HandholdIdcardVerification
* Description: 该 API 的功能是将手持身份证照中的被拍人的脸和手持身份证上的人脸进行比对，判断是否为同一人。
* @author HuangJian
* @date 2017年10月7日
*
*/
public class HandholdIdcardVerificationDemo extends BaseController{

	//@Test
	/*public void main(){
		try {
			String filepath = "‪C:/handerCard.jpg";
			MultipartEntity entity = new MultipartEntity();
			FileBody fileBody = new FileBody(new File(filepath));
			StringBody id = new StringBody(Keys.API_ID);
			StringBody secret = new StringBody(Keys.API_SECRET);
			
			entity.addPart("api_id", id);
			entity.addPart("api_secret", secret);
			entity.addPart("file", fileBody);
			
			
			//HttpClientPostUtil.httpClientPost(entity, ConstVo.HANDHOLD_IDCARD_VERIFICATION);
			
			HttpClient httpClient = new DefaultHttpClient();
			System.out.println(ConstVo.HANDHOLD_IDCARD_VERIFICATION);
			HttpPost httpPost = new HttpPost(ConstVo.HANDHOLD_IDCARD_VERIFICATION);
			
			
			
			httpPost.setEntity(entity);
			HttpEntity entitys = null;
			HttpResponse response = httpClient.execute(httpPost);
			if(response.getStatusLine().getStatusCode() == 200) {
				entitys = response.getEntity();
				BufferedReader br = new BufferedReader(new InputStreamReader(entitys.getContent()));
				String line = br.readLine();
				System.out.println(line);
				System.out.println("************成功************");
			}else{
				entitys = response.getEntity();
				String responseString = EntityUtils.toString(entitys);
				System.out.println("错误码："+response.getStatusLine().getStatusCode()+","+response.getStatusLine().getReasonPhrase());
				System.out.println("出错原因："+responseString);
				System.out.println("******失败******");
			}
			httpClient.getConnectionManager().shutdown();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("ok");
		
	}*/
	
	@Test
    public void test(){
    	 try {
    		 String path = super.projectPath + "/images/handerCard.jpg";
 			HttpClientPost(path);
 		} catch (ClientProtocolException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		} catch (IOException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
    	
    }

    //public static final String filepath = "C:/handerCard.jpg";//图片路径
    /*{
        "request_id":"TIDb0815cfe7987469ea6f6d0a8abe6ae1f",
        "status":"OK",
        "verify_score":0.41546568274497986,
        "image_id":"3552474e8e3f44c98fc1ca5220b59ca5"
    }*/
    public static void HttpClientPost(String imgPath) throws ClientProtocolException, IOException {
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost post = new HttpPost(ConstVo.HANDHOLD_IDCARD_VERIFICATION);
        FileBody fileBody = new FileBody(new File(imgPath));
        MultipartEntity entity = new MultipartEntity();

        
        entity.addPart("file", fileBody);
        post.setEntity(entity);

        HttpClientPostUtil.httpClientPost(entity, ConstVo.HANDHOLD_IDCARD_VERIFICATION);
  }

    
	/*public static void main(String[] args) {
	    try {
			HttpClientPost();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
}
