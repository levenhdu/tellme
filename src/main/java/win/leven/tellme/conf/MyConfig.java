package win.leven.tellme.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Leven on 2017/5/22.
 */
@Configuration
@ConfigurationProperties(prefix = "myconfig")
public class MyConfig
{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
