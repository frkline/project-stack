package com.frkline.project.stack.api;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
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
    "com.frkline.project.stack.api.service.external"
})
public class ApplicationConfig
    extends WebMvcConfigurerAdapter {

  public ApplicationConfig() {
    super();
  }

}
