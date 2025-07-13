package com.pig.design.listener;

import com.pig.design.config.ThreadPoolConfig;
import com.pig.design.dto.MailDTO;
import com.pig.design.event.BaseEvent;
import freemarker.template.Template;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.StringWriter;

@Slf4j
@Component
public class MailEventListener {

    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;

    @Async(ThreadPoolConfig.EVENT_THREAD_POOL)
    @Retryable(value = Exception.class, maxAttempts = 3, backoff = @Backoff(delay = 1000L))
    @EventListener
    public void listen(BaseEvent<MailDTO> event){
        MailDTO mailDTO = event.getData();

        log.info(mailDTO.getMail() + " " + mailDTO.getContent());

        String htmlContent = buildEmailHtml(mailDTO);

        log.info(htmlContent);
    }

    @Recover
    public void recover(Exception e, BaseEvent<MailDTO> event){
        // 记录日志
        log.error("邮件发送失败", e);
    }

    @SneakyThrows
    public String buildEmailHtml(MailDTO mailDTO){
        Template template = freeMarkerConfigurer.getConfiguration().getTemplate("email.html.ftl");

        //输出为字符串
        StringWriter stringWriter = new StringWriter();

        //渲染模版
        template.process(mailDTO,stringWriter);

        stringWriter.close();

        return  stringWriter.toString();
    }



}
