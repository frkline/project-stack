package com.frkline.project.stack.api.service.external.account;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

  @Inject
  public AccountControllerV1Impl(
      @Nonnull final MetricService metricService) {
    Preconditions.checkNotNull(
        metricService);
    this.metricService =
        metricService;
  }

  @RequestMapping("/ping")
  @ResponseBody
  public String ping() {
    return "pong";
  }

  @RequestMapping("/metrics")
  @ResponseBody
  public String metrics() {
    return "test wiring metrics: " + (this.metricService != null);
  }
}
