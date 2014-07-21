package com.frkline.project.stack.api;

import com.frkline.project.stack.common.service.ApplicationBase;
import com.frkline.project.stack.common.service.ApplicationBaseConfig;

/**
 * Bootstrap using Servlet 3.0
 * @author frank
 */
public class Application
    extends ApplicationBase {

  public Application() {
  }

  @Override
  protected Class<?>[] getConfigurations() {
    return new Class<?>[]{
      ApplicationConfig.class,
      ApplicationBaseConfig.class, };
  }
}
