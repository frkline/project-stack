package com.frkline.project.stack.common.service;

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
 * @author frank
 */
public abstract class ApplicationBase
    implements WebApplicationInitializer {

  private static final Logger LOGGER =
      LoggerFactory.getLogger(
          ApplicationBase.class);

  public ApplicationBase() {
  }

  @Override
  public void onStartup(
      @Nonnull final ServletContext servletContext)
    throws ServletException {

    // Create, start, and manage the application context
    LOGGER.info("Initializing application context...");
    final AnnotationConfigWebApplicationContext rootContext =
        new AnnotationConfigWebApplicationContext();
    rootContext.setAllowBeanDefinitionOverriding(
        true);
    rootContext.setAllowCircularReferences(
        true);
    rootContext.register(
        this.getAnnotatedRootContexts());
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

  /**
   * Retrieve root contexts to build the application
   * @return Annotated configuration classes
   */
  protected abstract Class<?>[] getAnnotatedRootContexts();

  /**
   * Retrieve servlet contents to wire in external services,
   * such as controllers
   * @return Annotated configuration classes
   */
  protected abstract Class<?>[] getAnnotatedDispatchServletContexts();

}
