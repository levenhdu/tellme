package win.leven.tellme.controller;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import win.leven.tellme.conf.MyBeanConfig;
import win.leven.tellme.conf.MyConfig;
import win.leven.tellme.dao.UserDao;
import win.leven.tellme.entity.Dog;
import win.leven.tellme.entity.UserEntity;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by leven on 2017/4/12.
 */
@org.springframework.web.bind.annotation.RestController
@EnableAutoConfiguration
public class RestController
{
    @Resource
    UserDao userDao;
    
    /*    @Autowired
    MyConfig config;*/
    @Resource
    MyBeanConfig myBeanConfig;
    
    Logger log = LoggerFactory.getLogger(RestController.class);
    
    @Value("${spring.mail.username}")
    private String fromEmail;
    
    @RequestMapping("/")
    ModelAndView home()
    {
        ModelAndView mv = new ModelAndView("email");
        mv.addObject("data", "leven");
        return mv;
    }
    
    @RequestMapping("/mail/send")
    String sendMail()
    {
        /* SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("levenhdu@sina.com");
        mailMessage.setTo("554093312@qq.com");
        mailMessage.setSubject("test");
        mailMessage.setText("spring boot 邮件测试");
        MailUtil.sendMail(mailMessage);*/
        //        System.out.println("Test" + config.getName());
        
        System.out.println(myBeanConfig.getName());
        return "";
    }
    
    @RequestMapping("/user/list")
    String userList()
    {
        List<UserEntity> userList = userDao.findUserList();
        log.info(JSON.toJSONString(userList));
        Map<String, Object> dataMap = new HashMap<>();
        userDao.findUserList();
        //            log.info(FreeMarkerUtil.generateHtml(dataMap,"email"));
        
        return "";
    }
    
    @ConfigurationProperties(prefix = "myBeanconfig")
    @Bean
    public MyBeanConfig getBeanConfig()
    {
        MyBeanConfig config = new MyBeanConfig();
        config.setName("teet");
        return config;
    }
    


    @RequestMapping("/dog/validate")
    public String getDog(@Validated @RequestBody Dog dog)
    {

        return dog.toString();
    }
    
}
