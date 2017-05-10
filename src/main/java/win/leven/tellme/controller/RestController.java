package win.leven.tellme.controller;

import com.alibaba.fastjson.JSON;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import win.leven.tellme.dao.UserDao;
import win.leven.tellme.entity.UserEntity;
import win.leven.tellme.util.FreeMarkerUtil;
import win.leven.tellme.util.MailUtil;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by leven on 2017/4/12.
 */
@org.springframework.web.bind.annotation.RestController
@EnableAutoConfiguration
public class RestController {
    @Resource
    UserDao userDao;

    Logger log= LoggerFactory.getLogger(RestController.class);

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
    String userList() {
        List<UserEntity> userList = userDao.findUserList();
        log.info(JSON.toJSONString(userList));
            Map<String, Object> dataMap = new HashMap<>();
            userDao.findUserList();
//            log.info(FreeMarkerUtil.generateHtml(dataMap,"email"));

        return "";
    }

}
