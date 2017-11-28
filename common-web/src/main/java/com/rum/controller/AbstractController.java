package com.rum.controller;

import com.mybatis.domain.PageBounds;
import com.rum.util.StringUtils;
import com.rum.utils.SessionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * 包含Controller公用的方法，其他的controller通过继承来使用这些公用的方法.
 *
 * @author tjwang
 */
public abstract class AbstractController {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    public static PageBounds getPageBounds() {
        HttpServletRequest request = SessionContext.getRequest();

        int page = getParameterForInt(request, "page", 1);
        int limit = getParameterForInt(request, "limit", 10);

        return new PageBounds(page, limit);
    }

    /**
     * 如果参数不存在或者不合法，返回默认值
     *
     * @param request
     * @param name
     * @param defaultValue
     * @return
     */
    public static int getParameterForInt(HttpServletRequest request, String name, int defaultValue) {
        String stringValue = request.getParameter(name);
        if (StringUtils.isBlank(stringValue)) {
            return defaultValue;
        }
        return StringUtils.parseStringToInt(stringValue, defaultValue);
    }

}
