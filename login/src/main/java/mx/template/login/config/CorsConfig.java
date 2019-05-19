package mx.template.login.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 跨域配置
 * @author mpd
 * @date 2019/5/19
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    private static final Logger logger = LoggerFactory.getLogger(CorsConfig.class);

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                //允许任何域名使用
                .allowedOrigins("*")
                //允许任何头
                .allowedHeaders("*")
                //允许任何方法
                .allowedMethods("*")
                //允许证书
                .allowCredentials(true)
                //最大时间
                .maxAge(3600);
        logger.info("add crossRegistry Mapping.");
    }


}
