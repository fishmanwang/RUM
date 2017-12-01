/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.rum.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author tjwang
 * @version $Id: AccessFilter.java, v 0.1 2017/12/1 0001 11:43 tjwang Exp $
 */
public class AccessFilter extends ZuulFilter {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        logger.info("Send {} request to {}", request.getMethod(), request.getRequestURL().toString());

        String accessToken = request.getParameter("accessToken");
        if (StringUtils.isBlank(accessToken)) {
            logger.info("Access token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            return null;
        }

        logger.info("Access token ok");
        return null;
    }
}
