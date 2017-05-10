package win.leven.tellme.util;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailPreparationException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * 邮件工具
 * Created by leven on 2017/4/13.
 */
public class MailUtil {
    private static final String MAIL_SENDER_NAME = "mailSender";
    private static JavaMailSender mailSender = null;

    private static JavaMailSender getMailSender() {
        if (mailSender == null) {
            mailSender = (JavaMailSender) SpringUtil.getBean(MAIL_SENDER_NAME);
        }
        return mailSender;
    }


    public static void sendMail(SimpleMailMessage mailMessage) {
        MailSender mailSender = getMailSender();
        if (mailSender != null) {
            mailSender.send(mailMessage);
        } else {
            throw new MailPreparationException("INIT FAILED");
        }
    }


    /**
     *
     * @param mimeMessageHelper
     * @throws MessagingException
     */
    public static void sendMail(MimeMessageHelper mimeMessageHelper) throws MessagingException {
        JavaMailSender mailSender = getMailSender();
        if (mailSender != null) {
            mailSender.send(mimeMessageHelper.getMimeMessage());
        } else {
            throw new MailPreparationException("INIT FAILED");
        }
    }

    public static MimeMessageHelper createMimeMessageHelper() throws MessagingException {
        return new MimeMessageHelper(getMailSender().createMimeMessage(), true);
    }
}
