/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.rum.util.converter;

/**
 * bean转换器，用于MapperUtil自定义转换格式
 *
 * @author tjwang
 * @version $Id: BeanConverter.java, v 0.1 2017/11/24 0024 18:22 tjwang Exp $
 */
public interface BeanConverter {

    /**
     * 转换
     * @param from
     * @param to
     * @return
     */
    <T, V> V convert(T from, V to);

}
