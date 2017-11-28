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

    public static <T> PageList<T> create(List<T> datas, Paginator paginator) {
        PageList<T> pb = new PageList<>(datas, paginator);
        return pb;
    }

    public static <T, V> PageList<V> create(List<T> page, Class<V> clazz, BeanConverter converter) {
        List<V> datas = BeanMapperUtil.mapList(page, clazz, converter);
        Paginator paginator = getPaginator(page);
        return create(datas, paginator);
    }

    public static Paginator getPaginator(List list) {
        Paginator p = null;
        if (list instanceof PageList) {
            PageList pb = (PageList) list;
            p = pb.getPaginator();
        }
        return p;
    }

}
