package com.frkline.project.stack.api;

import javax.annotation.Nonnull;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support
    .AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

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
    LOGGER.info("API starting...");

    // Create, start, and manage the application context
    LOGGER.info("Initializing application context...");
    final AnnotationConfigWebApplicationContext rootContext =
        new AnnotationConfigWebApplicationContext();
    rootContext.setAllowBeanDefinitionOverriding(
        true);
    rootContext.setAllowCircularReferences(
        true);
    rootContext.register(
        ApplicationConfig.class);
    servletContext.addListener(
        new ContextLoaderListener(
            rootContext));

    // Handle requests with the dispatcher servlet
    final ServletRegistration.Dynamic dispatcher =
        servletContext.addServlet(
            "dispatcher",
            new DispatcherServlet(
                rootContext));
    dispatcher.setLoadOnStartup(1);
    dispatcher.addMapping("/");

    // Character encoding filter
    final FilterRegistration.Dynamic encodingFilter =
        servletContext.addFilter(
            "encodingFilter",
        new CharacterEncodingFilter());
    encodingFilter.setInitParameter(
        "encoding",
        "UTF-8");
    encodingFilter.setInitParameter(
        "forceEncoding",
        "true");
    encodingFilter.addMappingForUrlPatterns(
        null,
        true,
        "/*");
  }
}
