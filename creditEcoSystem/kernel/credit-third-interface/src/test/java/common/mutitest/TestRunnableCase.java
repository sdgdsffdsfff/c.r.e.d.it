package common.mutitest;

import java.lang.reflect.Method;

import net.sourceforge.groboutils.junit.v1.TestRunnable;

import org.apache.log4j.Logger;

public class TestRunnableCase extends TestRunnable {

	private static Logger logger = Logger
			.getLogger(TestRunnableCase.class);
	
	private Object parameter;

	public TestRunnableCase(Object parameters) {
		super();
		this.parameter = parameters;
	}

	@Override
	public void runTest() throws Throwable {
		long start = System.currentTimeMillis();
		logger.info("test case execute begin.. threadName:"+Thread.currentThread().getName());
		Method method = MutiTestRunnerUtil.clazz.getMethod(MutiTestRunnerUtil.methodName, MutiTestRunnerUtil.methodTypeClzz);
		Object object = method.invoke(MutiTestRunnerUtil.service, parameter);
		logger.info(object.toString());
		logger.info("test case execute time: threadName:"+Thread.currentThread().getName()+" time:" + (System.currentTimeMillis() - start));
		logger.info("test case execute end.. threadName:"+Thread.currentThread().getName());
	}

}
