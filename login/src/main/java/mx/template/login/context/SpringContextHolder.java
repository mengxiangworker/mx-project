package mx.template.login.context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author mpd
 * @date 2019/5/19
 * 获取spring上下文
 */
@Component
public class SpringContextHolder implements ApplicationContextAware {
    
    private static final Logger logger = LoggerFactory.getLogger(SpringContextHolder.class);

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextHolder.applicationContext = applicationContext;
        logger.info("初始化 SpringContextHolder, applicationName:, {}",applicationContext.getApplicationName());
    }

    public static ApplicationContext getApplicationContext() {
        assertApplicationContext();
        return applicationContext;
    }

    private static void assertApplicationContext() {
        if (SpringContextHolder.applicationContext == null) {
            throw new RuntimeException("applicationContext属性为null,请检查是否注入了SpringContextHolder!");
        }
    }
}
