package com.yy.Util;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

/**
 * @author 袁毅
 * @date 2018/11/20 0020-上午 11:36
 */
public class EmailUtils {
    public String sendMail(String text, String subject, String location, String emailAdress,
                           JavaMailSender javaMailSender, Boolean type) {


        MimeMessage mMessage = javaMailSender.createMimeMessage();// 创建邮件对象
        MimeMessageHelper mMessageHelper;
        Properties prop = new Properties();
        try {
            // 从配置文件中拿到发件人邮箱地址
            prop.load(this.getClass().getResourceAsStream("/Static/mail.properties"));
            String from = prop.get("mail.smtp.username") + "";

            try {
                mMessageHelper = new MimeMessageHelper(mMessage, true, "UTF-8");

                // 发件人邮箱
                mMessageHelper.setFrom(from);
                // 收件人邮箱
                mMessageHelper.setTo(emailAdress);
                // 邮件的主题也就是邮件的标题
                mMessageHelper.setSubject(subject);
                // 邮件的文本内容，true表示文本以html格式打开
                if (type) {
                    mMessageHelper.setText(text, true);
                } else {
                    mMessageHelper.setText(text, false);
                }

                // 通过文件路径获取文件名字
                String filename = StringUtils.getFileName(location);
                // 定义要发送的资源位置
                File file = new File(location);
                FileSystemResource resource = new FileSystemResource(file);
              //  FileSystemResource resource2 = new FileSystemResource("D:/email.txt");
                mMessageHelper.addAttachment(filename, resource);// 在邮件中添加一个附件
            //    mMessageHelper.addAttachment("JavaApiRename.txt", resource2);//
                // 在邮件中添加一个附件
                javaMailSender.send(mMessage);// 发送邮件
            } catch (MessagingException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "发送成功";
    }

}