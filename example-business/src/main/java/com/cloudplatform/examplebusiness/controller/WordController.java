package com.cloudplatform.examplebusiness.controller;


import com.cloudplatform.examplebusiness.swaggertodoc.WordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Map;

/**
 * @ClassName:WordController
 * @Description:
 * @Author: WuDG
 * @Date:2020/3/30 16:53
 * @Version: V1.0
 * @since: JDK 1.8
 **/
@Slf4j
@Api(value = "word文档", description = "word文档导出",tags = {"word文档导出接口"})
@Controller
public class WordController {

    @Autowired
    private WordService tableService;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${swagger.url}")
    private String swaggerUrl;

    @Value("${server.port}")
    private Integer port;

    /**
     * 将 swagger 文档转换成 html 文档，可通过在网页上右键另存为 xxx.doc 的方式转换为 word 文档
     *
     * @param model
     * @param url   需要转换成 word 文档的资源地址
     * @return
     */
    @ApiOperation(value = "根据url下载word", notes = "根据url下载word",response = String.class)
    @Deprecated
    @GetMapping("/toWord")
    public String getWord(Model model, @RequestParam(value = "url", required = false) String url,
                          @RequestParam(value = "download", required = false, defaultValue = "1") Integer download) {
        url = StringUtils.defaultIfBlank(url, swaggerUrl);
        Map<String, Object> result = tableService.tableList(url);
        model.addAttribute("url", url);
        model.addAttribute("download", download);
        model.addAllAttributes(result);
        return "word";
    }

    /**
     * 将 swagger 文档一键下载为 doc 文档
     *
     * @param url      需要转换成 word 文档的资源地址
     * @param response
     */
    @ApiOperation(value = "下载word", notes = "下载word",response = String.class)
    @GetMapping("/downloadWord")
    public void word(@RequestParam(required = false) String url, HttpServletResponse response) {
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:" + port + "/toWord?download=0&url=" + StringUtils.defaultIfBlank(url, swaggerUrl), String.class);
        response.setContentType("application/octet-stream;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        try (BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream())) {
            response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode("toWord.doc", "utf-8"));
            byte[] bytes = forEntity.getBody().getBytes();
            bos.write(bytes, 0, bytes.length);
            bos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}