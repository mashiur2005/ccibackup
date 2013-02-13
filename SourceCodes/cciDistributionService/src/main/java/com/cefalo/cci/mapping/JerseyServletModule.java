package com.cefalo.cci.mapping;

import com.cefalo.cci.restResource.HelloResource;
import com.cefalo.cci.service.HelloService;
import com.cefalo.cci.service.HelloServiceImpl;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;
import com.sun.jersey.spi.container.servlet.ServletContainer;

import java.util.HashMap;
import java.util.Map;

public class JerseyServletModule extends com.sun.jersey.guice.JerseyServletModule {
  @Override
  protected void configureServlets() {
    bind(HelloResource.class);
    bind(HelloService.class).to(HelloServiceImpl.class);

    Map<String, String> params = new HashMap<String, String>();
    params.put(ServletContainer.JSP_TEMPLATES_BASE_PATH, "/WEB-INF/jsp");

    filter("/resource/*").through(GuiceContainer.class, params);
  }
}
