package com.hackagr1d.team4.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BasicAuthenticationFilter extends OncePerRequestFilter {


  private static final Logger CUSTOM_LOGGER = LogManager.getLogger(BasicAuthenticationFilter.class);

  @Override
  protected void doFilterInternal(
          final HttpServletRequest request, final HttpServletResponse response, final FilterChain chain)
      throws IOException, ServletException {



      chain.doFilter(request, response);


  }

}
