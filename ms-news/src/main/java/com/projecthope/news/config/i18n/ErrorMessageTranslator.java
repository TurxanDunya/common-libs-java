package com.projecthope.news.config.i18n;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class ErrorMessageTranslator {

    private final MessageSource messageSource;

    public ErrorMessageTranslator(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String toLocale(String errorCode) {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("error." + errorCode, null, locale);
    }

}