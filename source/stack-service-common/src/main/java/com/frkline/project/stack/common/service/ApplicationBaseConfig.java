package com.frkline.project.stack.common.service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation
    .WebMvcConfigurerAdapter;


/**
 * Wire application dependencies
 * @author frank
 */
@Configuration
@EnableWebMvc
@ComponentScan({
    "com.frkline.project.stack.common.service"
})
@PropertySource("classpath:application.properties")
public class ApplicationBaseConfig
    extends WebMvcConfigurerAdapter {

  public ApplicationBaseConfig() {
    super();
  }

}
