package support.message;

import java.io.Serializable;
import java.util.Map;

public abstract class NetMessage implements Serializable {

	// 设置状态码
	public abstract void setState(int state);

	// 存放数据
	public abstract void putData(String key, Object data);

	// 获取状态码
	public abstract int getState();

	// 获取数据集
	public abstract Map getDatas();

	// 获取数据
	public abstract Object getData(String key);
}
