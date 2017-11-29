/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.rum;

import com.google.common.collect.Lists;
import com.rum.service.EncryptionService;
import com.rum.utils.PageListJsonMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author tjwang
 * @version $Id: Application.java, v 0.1 2017/11/24 0024 14:57 tjwang Exp $
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = { "com.rum" })
@MapperScan("com.rum.dao")
public class Application extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public EncryptionService encryptionService() {
        return new EncryptionService();
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.extendMessageConverters(converters);

        Iterator<HttpMessageConverter<?>> iter = converters.iterator();
        while (iter.hasNext()) {
            if (iter.next() instanceof MappingJackson2HttpMessageConverter) {
                iter.remove();
            }
        }
        MappingJackson2HttpMessageConverter c = new MappingJackson2HttpMessageConverter();

        PageListJsonMapper mapper = new PageListJsonMapper();
        MediaType mediaType = new MediaType("application", "json", Charset.forName("UTF-8"));
        MediaType mediaType2 = new MediaType("application", "*+json", Charset.forName("UTF-8"));
        c.setSupportedMediaTypes(Lists.newArrayList(mediaType, mediaType2));
        c.setObjectMapper(mapper);

        converters.add(c);
    }
}
