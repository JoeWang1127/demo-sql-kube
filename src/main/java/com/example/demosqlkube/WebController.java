package com.example.demosqlkube;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/** Web app controller for sample app. */
@RestController
public class WebController {

  private final JdbcTemplate jdbcTemplate;
  private final Environment environment;

  public WebController(JdbcTemplate jdbcTemplate, Environment environment) {
    this.jdbcTemplate = jdbcTemplate;
    this.environment = environment;
  }

  @GetMapping("/getTuples")
  public List<String> getTuples() {
    return this.jdbcTemplate.queryForList("SELECT * FROM users").stream()
        .map(m -> m.values().toString())
        .collect(Collectors.toList());
  }
}
