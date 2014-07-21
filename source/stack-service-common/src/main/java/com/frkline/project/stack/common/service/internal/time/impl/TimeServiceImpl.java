package com.frkline.project.stack.common.service.internal.time.impl;

import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Named;
import javax.inject.Singleton;

import com.frkline.project.stack.common.service.internal.time.TimeService;

/**
 * @author frank
 */
@Named
@Singleton
@ThreadSafe
public class TimeServiceImpl
    implements TimeService {

  public TimeServiceImpl() {
  }

  @Override
  public long getTimeInMillisSinceEpoch() {
    return System.currentTimeMillis();
  }

}
