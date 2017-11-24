/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.rum.helper;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.rum.util.BeanMapperUtil;
import com.rum.util.converter.BeanConverter;

import java.util.List;

/**
 * 分页信息辅助类
 *
 * @author tjwang
 * @version $Id: PageInfoHelper.java, v 0.1 2017/11/24 0024 18:04 tjwang Exp $
 */
public class PageInfoHelper {

    public static <T> PageInfo<T> create(Page page, Class<T> clazz) {
        List<T> datas = BeanMapperUtil.mapList(page, clazz);
        Page<T> newPage = createNewPage(page);
        newPage.addAll(datas);
        PageInfo<T> pageInfo = new PageInfo(newPage);
        return pageInfo;
    }

    public static <T, V> PageInfo<V> create(Page<T> page, Class<V> clazz, BeanConverter converter) {
        List<V> datas = BeanMapperUtil.mapList(page, clazz, converter);
        Page<V> newPage = createNewPage(page);
        newPage.addAll(datas);
        PageInfo<V> pageInfo = new PageInfo(newPage);
        return pageInfo;
    }

    private static Page createNewPage(Page from) {
        Page to = BeanMapperUtil.map(from, Page.class);
        to.clear();
        return to;
    }
}
