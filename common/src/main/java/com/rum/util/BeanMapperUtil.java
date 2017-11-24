/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.rum.util;

import com.rum.util.converter.BeanConverter;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * 工具类，用于pojo转换
 *
 * @author tjwang
 * @version $Id: BeanMapperUtil.java, v 0.1 2017/2/16 0016 15:26 tjwang Exp $
 */
public class BeanMapperUtil {

    private static Logger logger = LoggerFactory.getLogger(BeanMapperUtil.class);

    /**
     * 值拷贝方式转换数据
     * @param sourceObject
     * @param destObjectclazz
     * @return
     */
    public static <T> T map(Object sourceObject, Class<T> destObjectclazz) {
        if (sourceObject == null)
            return null;
        T obj = null;
        try {
            obj = destObjectclazz.newInstance();
        } catch (InstantiationException e) {
            logger.warn(e.getMessage(), e);
        } catch (IllegalAccessException e) {
            logger.warn(e.getMessage(), e);
        }
        try {
            BeanUtils.copyProperties(obj, sourceObject);
        } catch (IllegalAccessException e) {
            logger.error(e.getMessage(), e);
        } catch (InvocationTargetException e) {
            logger.error(e.getMessage(), e);
        }
        return obj;
    }

    /**
     * 通过自定义转换器转换数据
     * @param sourceObject
     * @param destObjectclazz
     * @param converter
     * @return
     */
    public static <T, V> V map(T sourceObject, Class<V> destObjectclazz, BeanConverter converter) {
        if (sourceObject == null)
            return null;
        V obj = null;
        try {
            obj = destObjectclazz.newInstance();
        } catch (InstantiationException e) {
            logger.warn(e.getMessage(), e);
        } catch (IllegalAccessException e) {
            logger.warn(e.getMessage(), e);
        }

        return converter.convert(sourceObject, obj);
    }

    /**
     * 值拷贝方式转换数据列表
     * @param sourceList
     * @param destObjectclazz
     * @return
     */
    public static <T, V> List<T> mapList(Collection<V> sourceList, Class<T> destObjectclazz) {
        List<T> destinationList = new ArrayList<T>();
        if (sourceList == null || sourceList.size() == 0) {
            return destinationList;
        }
        for (Iterator<V> it = sourceList.iterator(); it.hasNext();) {
            destinationList.add(map(it.next(), destObjectclazz));
        }
        return destinationList;
    }

    /**
     * 通过自定义转换器转换数据列表
     * @param sourceList
     * @param destObjectclazz
     * @param converter
     * @return
     */
    public static <T, V> List<T> mapList(Collection<V> sourceList, Class<T> destObjectclazz, BeanConverter converter) {
        List<T> destinationList = new ArrayList<T>();
        if (sourceList == null || sourceList.size() == 0) {
            return destinationList;
        }
        for (Iterator<V> it = sourceList.iterator(); it.hasNext();) {
            destinationList.add(map(it.next(), destObjectclazz, converter));
        }
        return destinationList;
    }

}
