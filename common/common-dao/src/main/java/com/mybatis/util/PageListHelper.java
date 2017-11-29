/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.mybatis.util;

import com.mybatis.domain.PageList;
import com.mybatis.domain.Paginator;
import com.rum.util.BeanMapperUtil;
import com.rum.util.converter.BeanConverter;

import java.util.List;

/**
 * PageList帮助类
 *
 * @author tjwang
 * @version $Id: PageListHelper.java, v 0.1 2017/5/4 0004 11:53 tjwang Exp $
 */
public class PageListHelper {

    /**
     * 创建PageList信息
     * @param datas
     * @param paginator
     * @param <T>
     * @return
     */
    public static <T> PageList<T> create(List<T> datas, Paginator paginator) {
        PageList<T> pb = new PageList<>(datas, paginator);
        return pb;
    }

    /**
     * 将page中的数据转换为指定类型，通过值拷贝方式赋值
     * @param page
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> PageList<T> create(List page, Class<T> clazz) {
        List<T> datas = BeanMapperUtil.mapList(page, clazz);
        Paginator paginator = getPaginator(page);
        return create(datas, paginator);
    }

    /**
     * 将page中的数据转换为指定类型，通过指定convertor方式赋值
     * @param page
     * @param clazz
     * @param converter
     * @param <T>
     * @param <V>
     * @return
     */
    public static <T, V> PageList<V> create(List<T> page, Class<V> clazz, BeanConverter converter) {
        List<V> datas = BeanMapperUtil.mapList(page, clazz, converter);
        Paginator paginator = getPaginator(page);
        return create(datas, paginator);
    }

    /**
     * 获取分页信息
     * @param list
     * @return
     */
    public static Paginator getPaginator(List list) {
        Paginator p = null;
        if (list instanceof PageList) {
            PageList pb = (PageList) list;
            p = pb.getPaginator();
        }
        return p;
    }

}
