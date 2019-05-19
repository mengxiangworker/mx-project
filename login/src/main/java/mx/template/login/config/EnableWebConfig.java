package mx.template.login.config;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author mpd
 * @date 2019/5/19
 * 可引入注解声明
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({CorsConfig.class})
public @interface EnableWebConfig {
}
