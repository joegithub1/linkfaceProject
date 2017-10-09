package cn.hj.linkface.base;

public class BaseController {

	public String projectPath;
	public BaseController() {
		projectPath = System.getProperty("user.dir");
	}
}
