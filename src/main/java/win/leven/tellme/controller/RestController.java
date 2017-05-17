package win.leven.tellme.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import win.leven.tellme.dao.UserDao;
import win.leven.tellme.util.HttpClientUtil;
import win.leven.tellme.util.MailUtil;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * Created by leven on 2017/4/12.
 */
@org.springframework.web.bind.annotation.RestController
@EnableAutoConfiguration
public class RestController {
    @Resource
    UserDao userDao;

    Logger log = LoggerFactory.getLogger(RestController.class);

    @Value("${spring.mail.username}")
    private String fromEmail;

    @RequestMapping("/")
    ModelAndView home() {
        ModelAndView mv = new ModelAndView("email");
        mv.addObject("data", "leven");
        return mv;
    }

    @RequestMapping("/mail/send")
    String sendMail() {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("levenhdu@sina.com");
        mailMessage.setTo("554093312@qq.com");
        mailMessage.setSubject("test");
        mailMessage.setText("spring boot 邮件测试");
        MailUtil.sendMail(mailMessage);
        return "";
    }


    @RequestMapping("/user/list")
    String userList() throws IOException {
        return HttpClientUtil.post("https://hook.bearychat.com/=bwAyT/incoming/18b143f9b85b05209a1ef2da80db79a5", "{\"text\": \"Hello world\"}");
    }

}
