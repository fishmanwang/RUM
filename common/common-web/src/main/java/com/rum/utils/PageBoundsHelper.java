/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.rum.utils;

import com.google.common.collect.Lists;
import com.mybatis.domain.PageBounds;
import com.mybatis.domain.SortBy;
import com.rum.bean.PageInfo;
import com.rum.constant.RumConstants;
import com.rum.exception.ApplicationException;
import com.rum.exception.CommonErrorCode;
import com.rum.util.StringUtils;

import java.util.List;

/**
 *
 * @author tjwang
 * @version $Id: PageBoundsHelper.java, v 0.1 2017/11/29 0029 11:46 tjwang Exp $
 */
public class PageBoundsHelper {

    /**
     * 通过PageInfo创建PageBounds
     * @param pageInfo
     * @return
     */
    public static PageBounds create(PageInfo pageInfo) {
        PageBounds pb = new PageBounds();
        if (pageInfo == null) {
            return pb;
        }
        pb.setPage(pageInfo.getPage());
        pb.setLimit(pageInfo.getLimit());

        String order = pageInfo.getOrder();
        if (StringUtils.isBlank(order)) {
            return pb;
        }
        String[] os = order.split(RumConstants.COMMA);
        List<SortBy> ss = Lists.newArrayList();
        for (String o : os) {
            String[] items = o.split(RumConstants.COLON);
            if (items.length != 2) {
                throw new ApplicationException(CommonErrorCode.PARAM_ERROR, "排序参数错误，请修改后重试");
            }
            SortBy sortBy = SortBy.create(items[0], items[1]);
            ss.add(sortBy);
        }
        pb.setOrders(ss);
        return pb;
    }
}
