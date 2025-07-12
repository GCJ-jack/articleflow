package com.pig.design.controller;

import cn.hutool.extra.spring.SpringUtil;
import com.pig.design.dto.MailDTO;
import com.pig.design.event.BaseEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/event")
public class EventController {

    @Resource
    private ApplicationEventPublisher publisher;

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
}
