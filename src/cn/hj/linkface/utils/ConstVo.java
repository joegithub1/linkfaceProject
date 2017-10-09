package cn.hj.linkface.utils;

public class ConstVo {

	public static final String API_HOST="https://cloudapi.linkface.cn/";
	//该API的功能是将两张人脸图片进行比对，来判断是否为同一个人。
	public static final String HISTORICAL_SELFIE_VERIFICATION=API_HOST+"identity/historical_selfie_verification";
	
	public static final String FILE_PATH1="F:/faceMan.jpg";	
	public static final String FILE_PATH2="‪F:/faceWoMan.jpg";
	//该 API 的功能是将手持身份证照中的被拍人的脸和手持身份证上的人脸进行比对，判断是否为同一人。
	public static final String HANDHOLD_IDCARD_VERIFICATION=API_HOST+"identity/handhold_idcard_verification";
	public static final String FILE_PATH3="‪F:/handerCard.jpg";
	
	
	//对照片中的人脸进行检测，返回人脸数目和每张人脸的位置信息
	public static final String FACE_DETECT =API_HOST + "/face/face_detect";
	
	//该 API 用于识别人脸各项属性的值
	public static final String FACE_ATTRIBUTES_DETECT = API_HOST + "/face_attributes_detect";
	
}
