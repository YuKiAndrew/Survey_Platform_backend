/**
 * Copyright (c) 2005-2011 springside.org.cn
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *
 * $Id: ObjectMapper.java 1627 2011-05-23 16:23:18Z calvinxiu $
 */
package net.diaowen.common.plugs.mapper;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.lang.StringUtils;
import org.dozer.DozerBeanMapper;

import com.google.common.collect.Lists;
import net.diaowen.common.utils.ReflectionUtils;

/**
 Encapsulates Dozer for deep object-to-object conversion.
 Encapsulates Apache Commons BeanUtils for converting strings to objects.
 *
 */
public abstract class ObjectMapper {

	/**
	 * Hold a singleton instance of Dozer to avoid the resource consumption of repeatedly creating DozerMapper.
	 */
	private static DozerBeanMapper dozer = new DozerBeanMapper();

	/**
	 * Convert object types based on Dozer.
	 */
	public static <T> T map(Object source, Class<T> destinationClass) {
		return dozer.map(source, destinationClass);
	}

	/**
	 * Convert the types of objects in a Collection based on Dozer.
	 */
	public static <T> List<T> mapList(Collection sourceList, Class<T> destinationClass) {
		List<T> destinationList = Lists.newArrayList();
		for (Object sourceObject : sourceList) {
			T destinationObject = dozer.map(sourceObject, destinationClass);
			destinationList.add(destinationObject);
		}
		return destinationList;
	}

	static {
		//初始化日期格式为yyyy-MM-dd 或 yyyy-MM-dd HH:mm:ss
		registerDateConverter("yyyy-MM-dd,yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * Define the format for Apache BeanUtils DateConverter, allowing multiple formats to be registered, separated by ','.
	 */
	public static void registerDateConverter(String patterns) {
		DateConverter dc = new DateConverter();
		dc.setUseLocaleFormat(true);
		dc.setPatterns(StringUtils.split(patterns, ","));
		ConvertUtils.register(dc, Date.class);
	}

	/**
	 * Convert strings to the corresponding types based on Apache BeanUtils.
	 *
	 */
	public static Object convertToObject(String value, Class<?> toType) {
		Object cvt_value=null;
		try {
				cvt_value=ConvertUtils.convert(value, toType);
//			if(toType==Date.class){
//				SimpleDateFormat dateFormat=null;
//				try{
//					dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//					cvt_value=dateFormat.parse(value);
//				}catch(Exception e){
//					dateFormat=new SimpleDateFormat("yyyy-MM-dd");
//					cvt_value=dateFormat.parse(value);
//				}
//			}
		} catch (Exception e) {
			throw ReflectionUtils.convertReflectionExceptionToUnchecked(e);
		}
		return cvt_value;
	}

}
