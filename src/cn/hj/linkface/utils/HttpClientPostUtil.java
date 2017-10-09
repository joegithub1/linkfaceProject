package cn.hj.linkface.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpClientPostUtil {

	public static void httpClientPost(MultipartEntity entity,String url) throws ClientProtocolException, IOException{
		
		HttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(url);
		StringBody id = new StringBody(Keys.API_ID);
	    StringBody secret = new StringBody(Keys.API_SECRET);
	    entity.addPart("api_id", id);
        entity.addPart("api_secret", secret);
		
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
	}
	
	
	
	
}
