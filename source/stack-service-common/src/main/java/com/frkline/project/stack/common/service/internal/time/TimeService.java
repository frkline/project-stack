package com.frkline.project.stack.common.service.internal.time;

/**
 * Encapsulation of time into a service enables us to
 * test moving forwards and backwards in time
 * @author frank
 *
 */
public interface TimeService {

  /**
   * Retrieve the time since the epoch in millis
   * @return Milliseconds since the epoch
   */
  long getTimeInMillisSinceEpoch();

}
