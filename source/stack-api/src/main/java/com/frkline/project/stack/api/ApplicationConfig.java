package com.frkline.project.stack.api;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Wire application dependencies
 * @author frank
 */
@Configuration
@ComponentScan({
    "com.frkline.project.stack.api"
})
public class ApplicationConfig {

  public ApplicationConfig() {
  }

}
