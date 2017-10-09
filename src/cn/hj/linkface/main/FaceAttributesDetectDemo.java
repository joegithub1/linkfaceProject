package cn.hj.linkface.main;

import java.io.File;
import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.junit.Test;

import cn.hj.linkface.base.BaseController;
import cn.hj.linkface.utils.ConstVo;
import cn.hj.linkface.utils.HttpClientPostUtil;

/**
* Title: FaceAttributesDetectDemo
* Description: 该 API 用于识别人脸各项属性的值。
* @author HuangJian
* @date 2017年10月9日
*
*/
public class FaceAttributesDetectDemo extends BaseController{

	/**
	* Title: FaceAttributesDetectDemo.java
	* Description: 
	* @author HuangJian
	* @date 2017年10月9日
	*/
	@Test
	public void test(){
		String path = super.projectPath + "/images/gaoxing_man.jpg";
		/*try {
			httpClientPost(path);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		path = super.projectPath + "/images/shengqi01.jpg";
		
		try {
			httpClientPost(path);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void httpClientPost(String imgPath) throws ClientProtocolException, IOException{
		MultipartEntity entity = new MultipartEntity();
		FileBody fileBody = new FileBody(new File(imgPath));
		entity.addPart("file", fileBody);
		
		HttpClientPostUtil.httpClientPost(entity, ConstVo.FACE_ATTRIBUTES_DETECT);
		
		
	}
}
