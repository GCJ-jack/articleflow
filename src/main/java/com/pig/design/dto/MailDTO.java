package com.pig.design.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MailDTO {

    private String mail;

    private String title;

    private String content;

}
