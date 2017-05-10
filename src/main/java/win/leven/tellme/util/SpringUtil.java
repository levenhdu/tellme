package win.leven.tellme.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Spring上下文工具类
 * Created by leven on 2017/4/13.
 */

@Component
public class SpringUtil implements ApplicationContextAware {
    private static ApplicationContext atx;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (atx == null) {
            atx = applicationContext;
        }
    }

    public static ApplicationContext getApplicationContext() {
        return atx;
    }

    public static Object getBean(String name) {
        if (atx != null)
            return atx.getBean(name);
        return null;
    }

    public static <T> T getBean(Class<T> clazz) {
        if (atx != null)
            return atx.getBean(clazz);
        return null;
    }

    public static <T> T getBean(String name, Class<T> clazz) {
        if (atx != null)
            return atx.getBean(name, clazz);
        return null;
    }

}
