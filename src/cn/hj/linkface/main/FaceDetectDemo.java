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
* Title: FaceDetectDemo
* Description: 对照片中的人脸进行检测，返回人脸数目和每张人脸的位置信息
* @author HuangJian
* @date 2017年10月9日
*
*/
public class FaceDetectDemo extends BaseController{

	
	/*{
	    "request_id":"TID01209ea3b4734226903bb37ac7625a4e",
	    "status":"OK",
	    "face_num":15, 人脸数目
	    "face_rect":[
	        [
	            142,
	            291,
	            163,
	            312
	        ],
	        [
	            535,
	            280,
	            555,
	            301
	        ],
	        [
	            615,
	            281,
	            635,
	            301
	        ],
	        [
	            290,
	            337,
	            309,
	            356
	        ],
	        [
	            93,
	            288,
	            112,
	            307
	        ],
	        [
	            407,
	            286,
	            426,
	            305
	        ],
	        [
	            213,
	            288,
	            231,
	            306
	        ],
	        [
	            53,
	            296,
	            71,
	            314
	        ],
	        [
	            358,
	            163,
	            376,
	            180
	        ],
	        [
	            252,
	            289,
	            269,
	            306
	        ],
	        [
	            271,
	            162,
	            288,
	            179
	        ],
	        [
	            196,
	            214,
	            212,
	            231
	        ],
	        [
	            322,
	            165,
	            338,
	            182
	        ],
	        [
	            185,
	            207,
	            201,
	            223
	        ],
	        [
	            451,
	            208,
	            466,
	            223
	        ]
	    ],
	    "image_id":"8c7c485e60bd4075b3097c4b1d9b4eb1"
	}*/
	
	/**
	* Title: FaceDetectDemo.java
	* Description: 
	* @author HuangJian
	* @date 2017年10月9日
	*/
	@Test
	public void test(){
		
		try {
			String path = super.projectPath + "/images/students.jpg";
			httpClientPost(path);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static void httpClientPost(String imgPath) throws ClientProtocolException, IOException{
		
		MultipartEntity entity = new MultipartEntity();
		FileBody fileBody = new FileBody(new File(imgPath));
		entity.addPart("file", fileBody);
		HttpClientPostUtil.httpClientPost(entity, ConstVo.FACE_DETECT);
		
	}
	
}
