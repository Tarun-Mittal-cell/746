package com.sam2021.sam2021.WebConfig;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

@Configuration
@EnableWebMvc
public class MVCWebConfig implements WebMvcConfigurer{
    

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        //Login
        registry.addViewController("/registration.html").setViewName("registration.html");
        registry.addViewController("/login.html").setViewName("login.html");
        registry.addViewController("/").setViewName("login.html");

        registry.addViewController("/AuthorResearchPaperDeadlines").setViewName("AuthorResearchPaperDeadlines.html");
        registry.addViewController("/PaperReviews").setViewName("PaperReviews.html");

        //Admin
        registry.addViewController("/ManageUsersAdmin").setViewName("ManageUsersAdmin.html");
        registry.addViewController("/CreateReview").setViewName("CreateReview.html");
        registry.addViewController("/CreateNotificationTemplateAdmin").setViewName("CreateNotificationTemplateAdmin.html");
        registry.addViewController("/CreateDeadline").setViewName("CreateDeadline.html");

        //PCC
        registry.addViewController("/AssignPaperPCC").setViewName("AssignPaperPCC.html");
        registry.addViewController("/ReviewDeadlinesPCC").setViewName("ReviewDeadlinesPCC.html");
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(thymeleafTemplateResolver());
        return templateEngine;
    }
 
    @Bean
    public SpringResourceTemplateResolver thymeleafTemplateResolver() {
        SpringResourceTemplateResolver templateResolver 
          = new SpringResourceTemplateResolver();
        templateResolver.setPrefix("/WEB-INF/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("HTML");
        return templateResolver;
    }
    @Bean
    public ThymeleafViewResolver thymeleafViewResolver() {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());
        return viewResolver;
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //registry.addResourceHandler();
    }

    @Bean
    public MessageSource messagesource(){
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:validation");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
}
