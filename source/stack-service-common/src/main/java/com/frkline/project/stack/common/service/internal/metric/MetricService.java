package com.frkline.project.stack.common.service.internal.metric;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.health.HealthCheckRegistry;

/**
 * Register metrics and health checks in a common manner
 * @author frank
 */
public interface MetricService {

  /**
   * Retrieve the {@link MetricRegistry} to enable common
   * registration and exposure of metrics.
   * @see <a>http://metrics.codahale.com/manual/core/</a>
   * @return {@link MetricRegistry}
   */
  MetricRegistry getMetricRegistry();

  /**
   * Retrieve the {@link HealthCheckRegistry} to enable common
   * registration of health checks.
   * @see <a>http://metrics.codahale.com/manual/servlets/</a>
   * @return {@link HealthCheckRegistry}
   */
  HealthCheckRegistry getHealthCheckRegistry();
}
