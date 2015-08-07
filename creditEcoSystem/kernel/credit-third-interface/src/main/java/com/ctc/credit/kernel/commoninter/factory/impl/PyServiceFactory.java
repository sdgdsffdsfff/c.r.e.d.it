package com.ctc.credit.kernel.commoninter.factory.impl;

import java.net.MalformedURLException;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import com.caucho.hessian.client.HessianProxyFactory;
import com.ctc.credit.api.service.CreditApiService;
import com.ctc.credit.common.SpringContextHelper;
import com.ctc.credit.kernel.commoninter.category.CommonInterface;
import com.ctc.credit.kernel.commoninter.factory.FactoryCreator;
import com.ctc.credit.kernel.constants.PyConstants;
import com.ctc.credit.kernel.model.pengyuan.QueryConditionEntity;
import com.ctc.credit.sys.sysconfig.service.ConfigEntityService;

/**
 * @author sunny
 * 
 */
@Component(PyServiceFactory.BEAN_NAME)
public class PyServiceFactory extends FactoryCreator {

	public static final String BEAN_NAME = "pyServiceFactory";

	@Resource
	ConfigEntityService configEntityService;

	private static HessianProxyFactory factory;

	public static synchronized HessianProxyFactory getHessianFactory() {
		if (factory == null) {
			factory = new HessianProxyFactory();
			factory.setReadTimeout(25000);
			factory.setConnectTimeout(10000);
			factory.setChunkedPost(false);
		}
		
		return factory;
	}

	public static String url;// =
								// "http://127.0.0.1:8080/credit-esb/service/creditApiService";

	@Override
	public <T> CommonInterface createPyService(String beanName)
			throws MalformedURLException {
		CommonInterface commonInterface = null;
		CreditApiService creditApiService = null;
		PyServiceFactory.url = configEntityService
				.queryConfigValueByKey(PyConstants.PY_CONFIG_SERVICE_URL);
		HessianProxyFactory factory = getHessianFactory();
		String timeout = configEntityService
				.queryConfigValueByKey(PyConstants.PY_HESSIAN_TIMEOUT);
		if (StringUtils.isNotEmpty(timeout))
			factory.setConnectTimeout(Long.valueOf(timeout));
		creditApiService = (CreditApiService) factory.create(
				CreditApiService.class, PyServiceFactory.url);
		commonInterface = (CommonInterface) SpringContextHelper
				.getBean(beanName);
		commonInterface.doBefore(creditApiService);
		return commonInterface;
	}

}
