package com.ctc.credit.kernel.util;
import java.math.BigDecimal;
import java.text.DecimalFormat;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;



public class AmtUtil {
	
	
	/**金额为分的格式 */
	public static final String CURRENCY_FEN_REGEX = "\\-?[0-9]+";
	
	private static final int ROUNDING_MODE = BigDecimal.ROUND_HALF_UP;
	
	public static String formatYuan(String amtYuan){
		return new BigDecimal(amtYuan).setScale(2, ROUNDING_MODE).toString();
	}
	
	/**
	 * 元转分
	 * @param yuan
	 * @return
	 */
	public static String yuan2fen(Double yuan){
		String result = new String("");
		if(yuan != null){
			result =  String.valueOf(Math.round(yuan * 100.0D));
		}
		return result;
	}
	
	/**
	 * 将分为单位的转换为元 （除100）
	 * 
	 * @param amount
	 * @return
	 * @throws Exception 
	 */
	public static String changeF2Y(String amount) throws Exception{
		return BigDecimal.valueOf(Long.valueOf(amount)).divide(new BigDecimal(100)).setScale(2, ROUNDING_MODE).toString();
	}
	
	
	public static String fen2yuan(Long amount){
		if(amount == null){
			return null;
		}
		return BigDecimal.valueOf(amount).divide(new BigDecimal(100)).setScale(2, ROUNDING_MODE).toString();
	}
	
	
	public static String getRechargeFeeAmt(String transAmt,String rate){
		BigDecimal transAmtBigDecimal = new BigDecimal(transAmt);
		BigDecimal rateBigDecimal = new BigDecimal(rate);
		return transAmtBigDecimal.multiply(rateBigDecimal).setScale(2, ROUNDING_MODE).toString();
	}
	
	
	public static String getCashFeeAmt(String transAmt,String formula) throws Exception{
		ScriptEngineManager sem = new ScriptEngineManager();   
        ScriptEngine se = sem.getEngineByName("javascript");  
		String[] scopeArr = formula.split("[;]");
		for(int i=0;i<scopeArr.length;i++){
			String[] scopeData = scopeArr[i].split("[:]");
			String scope = scopeData[0];
			String data = scopeData[1];
			scope = scope.replaceAll("[?]", transAmt);
			Boolean res = (Boolean) se.eval("eval("+scope+")");
			if(res){
//				return data;
				return new BigDecimal(data).setScale(2, ROUNDING_MODE).toString();
			}
		}
		return null;
	}
	
	
//	public static Long getCouponAmt(Long amt){
//		String splitExp = "amt * 3 / 1000 / 100";			//结果以元为单位
//		JEP jep = new JEP(); 
//		jep.addVariable("amt", amt);  
//		jep.parseExpression(splitExp);  
//        double dd = jep.getValue();
//        BigDecimal decimal = new BigDecimal(dd).setScale(2, BigDecimal.ROUND_HALF_UP);
//        decimal = decimal.multiply(new BigDecimal("100"));		//乘以 100 变成以分为单位
//        return decimal.longValue();
//	}
	
	
	public static Long yuanToFen(String amt){
//			if(amt == null || "".equals(amt.trim())){
//				return null;
//			}
//			Double tmp = StringUtil.strToDouble(amt);
//			return ((Double)(tmp*100)).longValue();
		if(amt.isEmpty()){
			return 0L;
		}
		try{
			String res = yuan2fen(Double.valueOf(amt));
			return Long.valueOf(res);
		}catch(Exception ex){
			return 0L;
		}
		
	}
	
	/**
	 * 元格式化成千分位
	 * @param amt
	 * @return
	 */
	public static String yuanFormatThousand(String amt){
		DecimalFormat a = new DecimalFormat("#,###,###,###.##");
		String s= a.format(new BigDecimal(amt));
		return s;
	}
	
	
	
	
	
	public static void main(String[] args) throws Exception {
		/*String formula = "0<= ?  && ? <20000:1;20000<= ?  && ? <50000:2;?>=50000:3";
		String transAmt = "20001";
		System.out.println(getCashFeeAmt(transAmt, formula));
		*/
//		System.out.println(fen2yuan(10001));
//		System.out.println(getCouponAmt(111100L));
//		System.out.println(yuan2fen(Double.valueOf("2.591111")));
//		System.out.println(yuanToFen("1000000000"));
		System.out.println(yuanToFen(""));
	}

}
