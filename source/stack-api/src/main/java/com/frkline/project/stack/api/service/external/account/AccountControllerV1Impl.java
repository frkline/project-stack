package com.frkline.project.stack.api.service.external.account;

import javax.annotation.concurrent.ThreadSafe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

  public AccountControllerV1Impl() {
  }

  @RequestMapping("/ping")
  @ResponseBody
  public String ping() {
    LOGGER.info("pong");
    return "pong";
  }
}
