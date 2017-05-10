package win.leven.tellme.demo;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import win.leven.tellme.util.FreeMarkerUtil;
import win.leven.tellme.util.MailUtil;

import javax.mail.MessagingException;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by leven on 2017/4/13.
 */

@RestController
@EnableAutoConfiguration
public class MailTest {

    @RequestMapping("/test/mimeMail/send")
    String sendmimeMail() {
        try {
            MimeMessageHelper messageHelper= MailUtil.createMimeMessageHelper();
            messageHelper.setSubject("测试");
            messageHelper.setFrom("levenhdu@sina.com");
            messageHelper.setTo("554093312@qq.com");
            messageHelper.setText(FreeMarkerUtil.generateHtml(new HashMap<>(),"email")
                    , true);


//            FileSystemResource img = new FileSystemResource(new File("C://Users/leven/Desktop/htt.jpg"));

//            messageHelper.addInline("image1.jpg", img);//跟cid一致
//            messageHelper.addAttachment("image2.jpg", img);//跟cid一致
            MailUtil.sendMail(messageHelper);

        } catch (MessagingException | TemplateException | IOException e) {
            e.printStackTrace();
        }
        return "";
    }

}
