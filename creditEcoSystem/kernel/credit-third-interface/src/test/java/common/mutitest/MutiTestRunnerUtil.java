package common.mutitest;

import java.lang.reflect.Method;
import java.util.List;

import net.sourceforge.groboutils.junit.v1.MultiThreadedTestRunner;
import net.sourceforge.groboutils.junit.v1.TestRunnable;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.net.util.Base64;
import org.apache.log4j.Logger;

public class MutiTestRunnerUtil {

	private static Logger logger = Logger
			.getLogger(MutiTestRunnerUtil.class);
	
	public static Class<?> clazz;
	public static Object service;
	public static String methodName;
	public static Class<?> methodTypeClzz;
	public static String idFieldName;

	/**
	 * 初始化多线程测试用例
	 * 
	 * @param clazz
	 *            接口类名
	 * @param service
	 *            接口实现对象
	 * @param methodName
	 *            接口方法
	 * @param methodTypeClzz
	 *            接口参数对象类型
	 */
	public static void init(Class<?> clazz, Object service, String methodName,
			Class<?> methodTypeClzz,String idFieldName) {
		MutiTestRunnerUtil.clazz = clazz;
		MutiTestRunnerUtil.service = service;
		MutiTestRunnerUtil.methodName = methodName;
		MutiTestRunnerUtil.methodTypeClzz = methodTypeClzz;
		MutiTestRunnerUtil.idFieldName = idFieldName;
	}

	/**
	 * 运行多线程测试用例
	 * 
	 * @param pushCount
	 *            并发数量
	 * @param paras
	 *            参数数组
	 * @throws Exception 
	 */
	public static void runTestCase(int pushCount,List<Object> paras) throws Exception {
		logger.info("****** muti test case execute begin.. ******");
		long start = System.currentTimeMillis();
		TestRunnable[] trs = new TestRunnable[pushCount];
		Boolean setOtherReplace = true;//默认设置ID
		Method idSetmethod = null;
		if(methodTypeClzz.equals(String.class)){//如果字段值是String则执行替换，方便测试参数为string 的 接口
			setOtherReplace = false;
		}else{
			setOtherReplace = true;
			String methodName = "set" + idFieldName.substring(0, 1).toUpperCase() + idFieldName.substring(1);
			idSetmethod = methodTypeClzz.getMethod(methodName, String.class);
		}
		for (int i = 0; i < pushCount; i++) {
			int cnt = i%paras.size();
			Object object = paras.get(cnt);
			String rendomId = "BatchTst" + RandomStringUtils.randomAlphanumeric(20);
			Object ob;
			if(setOtherReplace){
				ob = BeanUtils.cloneBean(object);
				idSetmethod.invoke(ob, rendomId);
			}else {
				String string =(String) object;
				if (checkStrBase64(string)) {
					string = new String(Base64.decodeBase64(string));
					string = string.replace(idFieldName, rendomId);
					string = new String(Base64.encodeBase64(string.getBytes("UTF-8")));
				}else {
					string.replace(idFieldName, rendomId);
				}
				ob = string;
			}
			trs[i] = new TestRunnableCase(ob);
		}
		// 用于执行多线程测试用例的Runner，将前面定义的单个Runner组成的数组传入
		MultiThreadedTestRunner mttr = new MultiThreadedTestRunner(trs);
		try {
			// 开发并发执行数组里定义的内容
			mttr.runTestRunnables();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		logger.info("muti test case execute time:"+
				+ (System.currentTimeMillis() - start));
		logger.info("****** muti test case execute end.. ******");
	}
	
	/**
	 * 判断一个字符串 是否为 base64 编码
	 * @param str
	 * @return
	 */
	private static Boolean checkStrBase64(String str){
		if(str!=null&&str.equals(new String(Base64.encodeBase64(Base64.decodeBase64(str))))){
			return true;
		}
		return false;
	}
}
