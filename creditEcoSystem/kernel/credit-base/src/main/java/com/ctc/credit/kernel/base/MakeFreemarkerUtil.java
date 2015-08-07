package com.ctc.credit.kernel.base;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import freemarker.cache.StringTemplateLoader;
import freemarker.core.Environment;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

public class MakeFreemarkerUtil {
	protected static transient Log log = LogFactory
			.getLog(MakeFreemarkerUtil.class);

	public static boolean compile(Writer out, Map<String, Object> root,
			String body) throws Exception {
		try {
			String id = String.valueOf(System.currentTimeMillis());
			Configuration cfg = new Configuration();
			cfg.setEncoding(Locale.getDefault(), "UTF-8");
			cfg.setStrictSyntaxMode(true);
			cfg.setWhitespaceStripping(true);
			StringTemplateLoader stl = new StringTemplateLoader();
			stl.putTemplate(id, body);
			cfg.setTemplateLoader(stl);
			Template tpl = cfg.getTemplate(id);
			Environment env = tpl.createProcessingEnvironment(root, out);
			env.process();
			out.flush();
			return true;
		} catch (Exception e) {
			throw e;
		}
	}

	public static boolean compile(String templateFile, String outputFile,
			Map<String, Object> root) throws Exception {
		log.info("模板文件:" + templateFile);
		log.info("输出位置:" + outputFile);
		if (templateFile == null) {
			throw new Exception("模板文件不能为空!");
		}
		Configuration cfg = new Configuration();
		cfg.setEncoding(Locale.getDefault(), "UTF-8");
		cfg.setStrictSyntaxMode(true);
		cfg.setWhitespaceStripping(true);
		cfg.setNumberFormat("0");
		cfg.setDefaultEncoding("UTF-8");
		cfg.setObjectWrapper(new DefaultObjectWrapper());
		cfg.setClassForTemplateLoading(MakeFreemarkerUtil.class, "/template"); // ClassPath
																				// 搜索
		Writer out = null;
		try {
			out = new OutputStreamWriter(new FileOutputStream(outputFile));
			Template template = cfg.getTemplate(templateFile);
			template.setEncoding("UTF-8");
			template.process(root, out);
			out.flush();
			out.close();
			out = null;		
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
					out = null;
				} catch (IOException e) {
					log.error(e.getCause() + e.getMessage());
					e.printStackTrace();
				}
			}
		}
		return false;
	}
	public static void main(String[] args) throws Exception {
		HashMap<String, Object> root = new HashMap<String, Object>();
		root.put("time", new Date().toGMTString());
		MakeFreemarkerUtil.compile("test.ftl", "d:\\test.java",root );
	}
	
}
