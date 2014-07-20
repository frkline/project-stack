package com.frkline.project.stack.api;

import javax.annotation.Nonnull;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support
    .AnnotationConfigWebApplicationContext;

/**
 * Bootstrap using Servlet 3.0
 * @author frank
 */
public class Application
    implements WebApplicationInitializer {

  private static final Logger LOGGER =
      LoggerFactory.getLogger(
          Application.class);

  public Application() {
  }

  @Override
  public void onStartup(
      @Nonnull final ServletContext servletContext)
    throws ServletException {

    // Notify
    LOGGER.info("API starting");

    // Create, start, and manage the application context
    final AnnotationConfigWebApplicationContext applicationContext =
        new AnnotationConfigWebApplicationContext();
    applicationContext.setAllowBeanDefinitionOverriding(
        true);
    applicationContext.setAllowCircularReferences(
        true);
    applicationContext.addApplicationListener(
      new ApplicationListener<ApplicationEvent>() {
        @Override
        public void onApplicationEvent(
            final ApplicationEvent event) {
          LOGGER.info(
              "Context event: {}",
              event);
        }
      });
    applicationContext.register(
      ApplicationConfig.class);
    applicationContext.refresh();
    servletContext.addListener(
      new ContextLoaderListener(
          applicationContext));
  }
}
