package com.cloudplatform.examplebusiness.controller;

import com.cloudplatform.common.utils.R;
import com.cloudplatform.examplebusiness.service.MailService;
import com.cloudplatform.examplebusiness.utils.DownloadPicFromUrl;
import com.cloudplatform.examplebusiness.utils.HttpClientTest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName:SendMail
 * @Description:发送各类邮件
 * @Author: WuDG
 * @Date:2020/3/27 17:26
 * @Version: V1.0
 * @since: JDK 1.java8
 **/
//本controller的功能描述
@Api(value = "邮件", description = "邮件发送接口",tags = {"邮件发送接口"})
@RestController
@Slf4j
@RequestMapping("/mail")
public class SendMailController {

    @Autowired
    private MailService mailService;

    @Resource
    private TemplateEngine templateEngine;

    /**
     * 发送普通邮件
     */
    @ApiOperation(value = "发送普通邮件", notes = "hello",response = String.class)
    @RequestMapping(value = "/send",method = RequestMethod.GET)
    public R sendSimpleMail(@RequestParam("content") String content, @RequestParam("email") String email) {
        log.info("=====发送普通邮件====");
        mailService.sendSimpleMail(email, "普通", content);
        return R.ok("发送成功");
    }
    /**
     * 发送HTML格式邮件
     *
     * @throws MessagingException
     */
    @ApiOperation(value = "发送HTML格式邮件", notes = "hello",response = String.class)
    @RequestMapping(value = "/sendhtml",method = RequestMethod.GET)
    public R sendHtmlMail() throws MessagingException {
        log.info("=====发送HTML格式邮件====");
        String content = "<html>\n" +
                "<body>\n" +
                "<h3>hello world</h3>\n" +
                "<h1>html</h1>\n" +
                "<body>\n" +
                "</html>\n";
        mailService.sendHtmlMail("1490727316@qq.com", "发送HTML格式邮件", content);
        return R.ok("发送成功");
    }

    /**
     * 发送携带附件邮件
     *
     * @throws MessagingException
     */
    @ApiOperation(value = "发送携带附件邮件", notes = "hello",response = String.class)
    @RequestMapping(value = "/sendxls",method = RequestMethod.GET)
    public R sendAttachmentsMail() throws MessagingException {
        log.info("=====发送携带附件邮件====");
        String filePath = "F:/chat.xls";
        String content = "<html>\n" +
                "<body>\n" +
                "<h3>hello world</h3>\n" +
                "<h1>html</h1>\n" +
                "<h1>附件传输</h1>\n" +
                "<body>\n" +
                "</html>\n";
        mailService.sendAttachmentsMail("1490727316@qq.com", "发送携带附件邮件", content, filePath);
        return R.ok("发送成功");
    }

    /**
     * 携带图片的邮件
     *
     * @throws MessagingException
     */
    @ApiOperation(value = "携带图片的邮件", notes = "hello",response = String.class)
    @RequestMapping(value = "/sendpic",method = RequestMethod.GET)
    public R sendInlinkResourceMail(@RequestParam("email") String email) {
        Set<String> emails = new HashSet<>();
        emails.add(email);
        log.info("=====携带图片的邮件====");
        //TODO 改为本地图片目录
//        String imgPath = "F:/web.jpg";
        String imgPath = DownloadPicFromUrl.getPath();

        String rscId = "admxj001";
        String content = "<html>" +
                "<title>图片</title>"+
                "<body>" +
                "<img src='cid:" + rscId + "'></img>" +
                "<body>" +
                "</html>";
        emails.stream().forEach(x -> mailService.sendInlinkResourceMail(x, "携带图片的邮件", content, imgPath, rscId));
        return R.ok("发送成功");
    }

    /**
     * 发送自定义模板的邮件
     *
     * @throws MessagingException
     */
    @ApiOperation(value = "发送自定义模板的邮件", notes = "hello",response = String.class)
    @RequestMapping(value = "/sendtemplate",method = RequestMethod.GET)
    public R testTemplateMailTest() throws MessagingException {
        log.info("=====发送自定义模板的邮件====");
        Context context = new Context();
        context.setVariable("id", "WuDg");
        context.setVariable("content", HttpClientTest.getContent());
        String emailContent = templateEngine.process("emailTeplate", context);
        mailService.sendHtmlMail("1490727316@qq.com", "发送自定义模板的邮件", emailContent);
        return R.ok("发送成功");
    }
}
