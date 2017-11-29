/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.rum.integration;

import com.rum.facade.UserFacade;
import com.rum.facade.UserFacadeFallback;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 *
 * @author tjwang
 * @version $Id: UserFacadeRefactor.java, v 0.1 2017/11/29 0029 14:53 tjwang Exp $
 */
@FeignClient(value = "user-service", fallback = UserFacadeFallback.class)
public interface UserFacadeRefactor extends UserFacade {
}
