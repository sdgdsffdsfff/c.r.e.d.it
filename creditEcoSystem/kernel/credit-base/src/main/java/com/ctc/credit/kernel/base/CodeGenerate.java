package com.ctc.credit.kernel.base;

import java.util.HashMap;

import com.ctc.credit.kernel.util.FileUtil;

public class CodeGenerate {
	static {
	}
	//public static String basePath = CodeGenerate.class.getResource("/").getPath().substring(0,CodeGenerate.class.getResource("/").getPath().lastIndexOf("credit-base"));
	public static String basePath = "C:/Users/daniel/workspace/creditEcoSystem/kernel/";
	public static String module = "person";
	public static String entity = "Test";
	public static String idType = "Long";
	public static HashMap<String, Object> root = new HashMap<String, Object>();

	public static void genDao() throws Exception {
		String outPutDir = basePath + "credit-base" + "/target/codegen/"
		+ module + "/dao/";
		FileUtil.checkDirExists(outPutDir);
		MakeFreemarkerUtil.compile("Dao.ftl", outPutDir +entity + "Dao.java", root);
	}
	public static void genDaoHibernate() throws Exception {
		String outPutDir = basePath + "credit-base" + "/target/codegen/"
		+ module + "/dao/hibernate/";
		FileUtil.checkDirExists(outPutDir);
		MakeFreemarkerUtil.compile("DaoHibernate.ftl", outPutDir +entity + "DaoHibernate.java", root);
	}
	public static void genService() throws Exception {
		String outPutDir = basePath + "credit-base" + "/target/codegen/"
		+ module + "/service/";
		FileUtil.checkDirExists(outPutDir);
		MakeFreemarkerUtil.compile("Service.ftl", outPutDir +entity + "Service.java", root);
	}
	public static void genServiceImpl() throws Exception {
		String outPutDir = basePath + "credit-base" + "/target/codegen/"
		+ module + "/service/impl/";
		FileUtil.checkDirExists(outPutDir);
		MakeFreemarkerUtil.compile("ServiceImpl.ftl", outPutDir +entity + "ServiceImpl.java", root);
	}
	
	public static void genAction() throws Exception {
		String outPutDir = basePath + "credit-base" + "/target/codegen/portal/controller/";
		FileUtil.checkDirExists(outPutDir);
//		MakeFreemarkerUtil.compile("Controller.ftl", outPutDir +entity + "Controller.java", root);
	}
	public static void genSpring() throws Exception {
		String outPutDir = basePath + "credit-base" + "/target/codegen/"
		+ module + "/";
		FileUtil.checkDirExists(outPutDir);
//		MakeFreemarkerUtil.compile("spring.ftl", outPutDir +entity + "_spring.txt", root);
	}
	private static void genSearchBean() throws Exception {
		String outPutDir = basePath + "credit-base" + "/target/codegen/"
		+ module + "/formbean/";
		FileUtil.checkDirExists(outPutDir);
//		MakeFreemarkerUtil.compile("SearchBean.ftl", outPutDir +entity + "SearchBean.java", root);
		
	}
	private static void genModel() throws Exception {
		String outPutDir = basePath + "credit-base" + "/target/codegen/portal/model/";
		FileUtil.checkDirExists(outPutDir);
//		MakeFreemarkerUtil.compile("Model.ftl", outPutDir +entity + "Model.jsp", root);
	}
	private static void genGrid() throws Exception {
		String outPutDir = basePath + "credit-base" + "/target/codegen/portal/grid/";
		FileUtil.checkDirExists(outPutDir);
//		MakeFreemarkerUtil.compile("grid.ftl", outPutDir +entity + "Grid.jsp", root);
	}
	public  static void genCode(Class cls) throws Exception{
		genCode(null,null,null,cls);
	}
	
	public  static void genCode(String entity) throws Exception{
		genCode(entity,"pengyuan",null,null);
	}
	public  static void genCode(String entity1,String module1,String idType1,Class cls) throws Exception{
			if(entity1 == null){
				entity="SwRepayModel";
			}else{
				entity = entity1;
			}
			if(cls != null){
				entity = cls.getSimpleName();
				root.put("fields", cls.getDeclaredFields());
			}
			if(idType1 == null){
				idType="Integer";
			}else{
				idType= idType1;
			}
			if(module1 == null){
				module="product";
			}else{
				module= module1;
			}
			
			root.put("module", module);
			root.put("Module", module.substring(0,1).toUpperCase() + module.substring(1));
			root.put("entity", entity);
			root.put("entitylower", entity.substring(0,1).toLowerCase() + entity.substring(1));
			root.put("entitylowerlower", entity.toLowerCase());
			root.put("idType", idType);
			genDao();
			genDaoHibernate();
			genService();
			genServiceImpl();
//			genSearchBean();
//			genAction();
//			genModel();
//			genGrid();
	}

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		genCode(SortBean.class);
	}
	
}
