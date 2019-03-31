package cn.kgc.tangcco.tcmp073.qizu.recruit.user.encryption;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.commons.codec.digest.DigestUtils;

public class Encryption {
	
	/**
	 * MD5加密
	 * @param input
	 * @return
	 */
	public static String md5Encode(byte[] input) {
		return DigestUtils.md5Hex(input);
	}
	
	/**
	 * base64编码
	 * @param input
	 * @return
	 */
	public static String base64Encode(byte[] input) {
		String result = null;
		try {
			//反射得到该类
			Class forName = Class.forName("com.sun.org.apache.xerces.internal.impl.dv.util.Base64");
			//得到加密方法
			Method method = forName.getMethod("encode", byte[].class);
			//执行 返回String字符串
			result = (String) method.invoke(null, input);
		} catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	
}
