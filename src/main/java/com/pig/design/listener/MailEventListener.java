package com.pig.design.listener;

import com.pig.design.dto.MailDTO;
import com.pig.design.event.BaseEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MailEventListener {

    @EventListener
    public void listen(BaseEvent<MailDTO> event){
        MailDTO mailDTO = event.getData();

        log.info(mailDTO.getMail() + " " + mailDTO.getContent());
    }
}
