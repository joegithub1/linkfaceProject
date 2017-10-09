package cn.hj.linkface.main;

import java.io.File;
import java.io.IOException;

import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;

import cn.hj.linkface.utils.ConstVo;
import cn.hj.linkface.utils.HttpClientPostUtil;

/**
* Title: HistoricalSelfieVerification
* Description: 该API的功能是将两张人脸图片进行比对，来判断是否为同一个人。
* @author HuangJian
* @date 2017年10月6日
*
*/
public class HistoricalSelfieVerification {

	public static void main(String[] args) {
		//confidence	float	置信度。值为 0~1，值越大表示两张照片是同一个人的可能性越大
		
		//不同照片结果
		/*{
		    "request_id":"TIDbd03bfc697894ba2911fb426a7cf8d9a",
		    "status":"OK",
		    "confidence":0.41519254446029663,
		    "selfie":{
		        "image_id":"bf2e2ef842f641bab39f1202154e4823"
		    },
		    "historical_selfie":{
		        "image_id":"c513a3d19e464c3e851dbdc6ea555c4c"
		    }
		}*/
		
		//相同照片结果
		/*{
		    "request_id":"TIDecbe594034d14c93977349ac61dded2d",
		    "status":"OK",
		    "confidence":1,
		    "selfie":{
		        "image_id":"5e7bd9feaaad44deb5635c8f0af6e009"
		    },
		    "historical_selfie":{
		        "image_id":"07abc1796339474583de7f2a8e3ad660"
		    }
		}*/
		try {
			FileBody fileBody1 = new FileBody(new File(ConstVo.FILE_PATH1));
			
			FileBody fileBody2 = new FileBody(new File(ConstVo.FILE_PATH2));
			StringBody url1 = new StringBody("http://seopic.699pic.com/photo/50044/0464.jpg_wh1200.jpg");
			// http://seopic.699pic.com/photo/10021/0311.jpg_wh1200.jpg
			StringBody url2 = new StringBody("http://seopic.699pic.com/photo/50044/0464.jpg_wh1200.jpg");
			
			
			MultipartEntity entity = new MultipartEntity();
			//第一张图片的selfie_file，本地上传选取此参数
			//entity.addPart("selfie_file",fileBody1);
			//第二张图片的selfie_file，本地上传选取此参数
			//entity.addPart("historical_selfie_file", fileBody2);
			
			entity.addPart("selfie_url",url1);
			entity.addPart("historical_selfie_url", url2);
			
			
			HttpClientPostUtil.httpClientPost(entity,ConstVo.HISTORICAL_SELFIE_VERIFICATION);
			System.out.println("---------------------------");
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		
	}
}
