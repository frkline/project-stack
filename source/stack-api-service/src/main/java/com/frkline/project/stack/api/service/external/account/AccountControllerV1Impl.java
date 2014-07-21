package com.frkline.project.stack.api.service.external.account;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.frkline.project.stack.common.Constants;
import com.frkline.project.stack.common.service.internal.metric.MetricService;
import com.google.common.base.Preconditions;

/**
 *
 * @author frank
 */
@Controller
@ThreadSafe
@RequestMapping("/account/v1")
public class AccountControllerV1Impl {

  private static final Logger LOGGER =
      LoggerFactory.getLogger(
          AccountControllerV1Impl.class);

  private final MetricService metricService;
  private final String application;

  @Inject
  public AccountControllerV1Impl(
      @Nonnull final Environment environment,
      @Nonnull final MetricService metricService) {
    Preconditions.checkNotNull(
        environment);
    Preconditions.checkNotNull(
        metricService);
    this.application =
      environment.getRequiredProperty(
          Constants.ENV_APPLICATION_NAME);
    this.metricService =
        metricService;
  }

  @RequestMapping("/ping")
  @ResponseBody
  public String ping() {
    return this.application + " - pong";
  }

  @RequestMapping("/metrics")
  @ResponseBody
  public String metrics() {
    return "test wiring metrics: " + (this.metricService != null);
  }
}
