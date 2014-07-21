package com.frkline.project.stack.common.service.internal.metric.impl;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.springframework.core.env.Environment;

import com.codahale.metrics.JmxReporter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.health.HealthCheckRegistry;
import com.frkline.project.stack.common.Constants;
import com.frkline.project.stack.common.service.internal.metric.MetricService;
import com.google.common.base.Preconditions;

/**
 * @author frank
 */
@Named
@Singleton
@ThreadSafe
public class MetricServiceImpl
    implements MetricService {

  private final MetricRegistry metricRegistry;
  private final HealthCheckRegistry healthCheckRegistry;

  @Inject
  public MetricServiceImpl(
      @Nonnull final Environment environment) {
    Preconditions.checkNotNull(environment);
    this.metricRegistry =
        new MetricRegistry();
    this.healthCheckRegistry =
        new HealthCheckRegistry();
    final String applicationName =
        environment
            .getRequiredProperty(
                Constants.APPLICATION_NAME);
    JmxReporter
        .forRegistry(
            this.metricRegistry)
        .inDomain(
            applicationName)
        .build()
        .start();
  }

  @Override
  public MetricRegistry getMetricRegistry() {
    return this.metricRegistry;
  }

  @Override
  public HealthCheckRegistry getHealthCheckRegistry() {
    return this.healthCheckRegistry;
  }

}
