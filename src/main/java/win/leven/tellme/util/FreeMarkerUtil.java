package win.leven.tellme.util;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Created by leven on 2017/4/13.
 */
@Component
public class FreeMarkerUtil {

    private static Configuration configuration;

    private static Configuration getConfiguration() {
        if (configuration == null) {
            configuration = (Configuration) SpringUtil.getBean("freeMarkerConfiguration");
        }
        return configuration;
    }

    public static String generateHtml(Map<String, Object> data, String templateName) throws IOException, TemplateException {
        Template template = getConfiguration().getTemplate(templateName + ".ftl");

        String path = "./" + UUID.randomUUID();
        File file = new File(path);
        if (!file.exists()) {
            Check.orThrow(file.createNewFile(), "CREATE HTML FAILED");
        }
        FileWriter ops = new FileWriter(file);


        template.process(data, ops);
        ops.close();

        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        String line;
        StringBuilder content = new StringBuilder();
        while ((line = br.readLine()) != null) {
            content.append(line);
        }
        br.close();
        if (file.exists()) {
            Check.orThrow(file.delete(), "FILE DELETE FAILED");
        }
        return content.toString();
    }

}
