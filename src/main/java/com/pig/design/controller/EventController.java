package com.pig.design.controller;

import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.extra.spring.SpringUtil;
import com.pig.design.dto.MailDTO;
import com.pig.design.event.BaseEvent;
import freemarker.template.Template;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jms.JmsProperties;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.annotation.Resource;
import java.io.StringWriter;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/event")
public class EventController {

    @Resource
    private ApplicationEventPublisher publisher;

    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;

    @GetMapping("/file-export")
    public String fileExport(){
        // publisher.publishEvent(new BaseEvent<>("数据", this));
        log.info("文件导出到数据库...");

        MailDTO mailDTO = MailDTO.builder()
                .mail("xxxx@qq.com")
                .title("文件导出到数据库完成")
                .content("文件导出到数据库完成了, 请及时查收").build();


        SpringUtil.publishEvent(new BaseEvent<>(mailDTO, this));

        return "ok";
    }

    @SneakyThrows
    @GetMapping("/test")
    private String testFtl(String username){
        Template template = freeMarkerConfigurer.getConfiguration().getTemplate("test.txt.ftl");

        Map<String,Object> map = new HashMap<>();

        map.put("username",username);
        map.put("curDate", DateUtil.format(LocalDateTime.now(),"yyyy-MM-dd HH:mm:ss"));

        map.put("hobbies", ListUtil.of("吃饭","睡觉"));

        //输出为字符串
        StringWriter resultStr = new StringWriter();

        //渲染模版
        template.process(map, resultStr);

        //关闭流
        resultStr.close();

        return  resultStr.toString();
    }
}
