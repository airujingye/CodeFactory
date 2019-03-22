package com.sweet.helper;

public class StringUtil {

	/**
	 * 检查字符串是否为空
	 * 
	 * @param str
	 *            字符串
	 * @return
	 */
	public static boolean isEmpty(Object str) {
		if (str == null) {
			return true;
		} else if (isEmpty(str.toString())) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 检查字符串是否为空
	 * 
	 * @param str
	 *            字符串
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if (str == null) {
			return true;
		} else if (str.length() == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 检查字符串是否为空
	 * 
	 * @param str
	 *            字符串
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		if (str == null || str.equalsIgnoreCase("null")) {
			return false;
		} else if (str.length() == 0) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 检查字符串是否为空
	 * 
	 * @param str
	 *            字符串
	 * @return
	 */
	public static boolean isNotEmpty(Object str) {
		return (!isEmpty(str));
	}
	/**
	 * 字段转换方法
	 * @param context
	 * @param len
	 * @param repaceContext
	 * @return
	 */
	public static String cfd(String context) {
		if (isEmpty(context)) 
			return null;
		StringBuffer localStringBuffer = new StringBuffer("");
		context=context.replace("_", "");
		for (int i = 0; i < context.length(); i++) {
			String zf = context.charAt(i)+"";
			if(i==0){
				localStringBuffer.append(zf.toLowerCase());
			}
//			else if(zf.equalsIgnoreCase("_")){
//				i++;
//				zf = context.charAt(i)+"";
//				localStringBuffer.append(zf.toUpperCase());
//			}
			else{
				localStringBuffer.append(zf.toLowerCase());
			}
		}
//		if(localStringBuffer.substring(0, 1).toString().equalsIgnoreCase("is")){
//			localStringBuffer.setCharAt(2, localStringBuffer.charAt(2));
//		}
		//如果以is开头，则将第三个字符转换为大写。如 isparent -->> isParent
		if(localStringBuffer.substring(0, 2).toString().equalsIgnoreCase("is")){
			localStringBuffer.replace(2, 3, (localStringBuffer.charAt(2)+"").toUpperCase());
		}
		return localStringBuffer.toString();
	}
}
