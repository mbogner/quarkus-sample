package dev.mbo.quarkus.sample.service;

import io.quarkus.logging.Log;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HealthService {

  public String getHealth() {
    Log.infov("Simple {0},{0},{1}", 1, "test"); // jboss-logging MessageFormat style
    return "OK";
  }

}
