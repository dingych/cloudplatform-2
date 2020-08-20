package com.cloudplatform.examplebusiness.config;

import com.cloudplatform.common.entity.ResultBody;
import com.cloudplatform.common.exception.BusinessException;
import com.cloudplatform.common.exception.CommonEnum;
import com.cloudplatform.examplebusiness.service.MailService;
import com.cloudplatform.examplebusiness.utils.DownloadPicFromUrl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName:GlobalExceptionHandler
 * @Description:
 * @Author: WuDG
 * @Date:2020/5/8 9:23
 * @Version: V1.0
 * @since: JDK 1.8
 **/
@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @Autowired
    private MailService mailService;

    /**
     * 处理自定义的业务异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public ResultBody businessExceptionHandler(HttpServletRequest request, BusinessException e){
        logger.error("发生业务异常！原因是：{}",e.getErrorMsg());
        String imgPath = DownloadPicFromUrl.getPath();

        String rscId = "admxj001";
        String content = "<html>" +
                "<title>图片</title>"+
                "<body>" +
                "<img src='cid:" + rscId + "'></img>" +
                "<body>" +
                "</html>";
        mailService.sendInlinkResourceMail("1490727316@qq.com", "项目异常通知", content+"\n错误信息:"+e.getErrorMsg()+"\n请求路径:"+request.getRequestURI(), imgPath, rscId);
        return ResultBody.error(e.getErrorCode(),e.getErrorMsg());
    }

    /**
     * 处理空指针的异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value =NullPointerException.class)
    @ResponseBody
    public ResultBody exceptionHandler(HttpServletRequest req, NullPointerException e){
        logger.error("发生空指针异常！原因是:",e);
        return ResultBody.error(CommonEnum.BODY_NOT_MATCH);
    }


    /**
     * 处理其他异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value =Exception.class)
    @ResponseBody
    public ResultBody exceptionHandler(HttpServletRequest req, Exception e){
        logger.error("未知异常！原因是:",e);
        return ResultBody.error(CommonEnum.INTERNAL_SERVER_ERROR);
    }
}
