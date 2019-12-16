package com.hackagr1d.team4.domain.model;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

public class GenericLoggableObject {

  @Override
  public String toString() {

    return new ReflectionToStringBuilder(this, JSON_STYLE).toString();
  }
}
