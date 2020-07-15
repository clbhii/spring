package com.cl.consumer.util.common;



import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author cl 2017年6月23日
 *
 */
public class ListUtil {
	
	private final static String DEFUALT_SEPARATE = ",";
	
	private ListUtil() {
		
	}
	
	public static <T> List<T> convertList(String strs, Class<T> cls) {
		return convertList(strs, cls, DEFUALT_SEPARATE);
	}
	
	public static <T> List<T> convertList(String strs, Class<T> cls, String separator) {
		if(StringUtil.isEmpty(strs)){
			return null;
		}
		if(StringUtil.isEmpty(separator)) {
			separator = DEFUALT_SEPARATE;
		}
		String[] arr = strs.split(separator);
		List list = new ArrayList<>();
		for(String str : arr) {
			if(cls.equals(String.class)){
				list.add(str);
			}else if(cls.equals(Integer.class)){
				list.add(Integer.parseInt(str));
			}
			
		}
		return list;
	}
	
	public static <T> String join(List<T> list) {

		return join(list, DEFUALT_SEPARATE);
	}
	
	public static <T> String join(List<T> list, String separator) {
		if(list == null) {
			return null;
		}
		if(StringUtil.isEmpty(separator)) {
			separator = DEFUALT_SEPARATE;
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0, len = list.size(); i < len; i++) {
			T t = list.get(i);
			sb.append(t.toString());
			if(i < len - 1){
				sb.append(separator);
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		List<String> list = ListUtil.convertList("1,2,3", String.class);
		System.out.println(list);
		List<Integer> integerList = ListUtil.convertList("1,2,3", Integer.class);
		System.out.println(integerList);
		
		System.out.println(ListUtil.join(list, ","));
	}
}
