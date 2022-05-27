package com.xiaoyuan.emaillogin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * FileName:    ThreadService
 * Author:      小袁教程
 * Date:        2022/5/26 15:32
 * Description:
 */
@Component
public class ThreadService {

    @Autowired
    private MailService mailService;

    /**
     * 发送邮箱
     * @param to 收件人
     * @param theme 主题
     * @param content 内容
     */
    @Async("taskExecutor")
    public void sendSimpleMail(String to, String theme, String content) {
        mailService.sendSimpleMail(to, theme, content);
    }
}
