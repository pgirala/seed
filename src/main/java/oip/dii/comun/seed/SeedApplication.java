package oip.dii.comun.seed;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SeedApplication {
  @Configuration
  @Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
  protected static class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
      http
        .httpBasic()
      .and()
        .authorizeRequests()
          .antMatchers("/index.html", "/", "/home", "/login").permitAll()
          .anyRequest().authenticated();
    }
  }

  @RequestMapping("/user")
  public Principal user(Principal user) {
    return user;
  }

  @RequestMapping("/resource")
  public Map<String,Object> home() {
    Map<String,Object> model = new HashMap<String,Object>();
    model.put("id", UUID.randomUUID().toString());
    model.put("content", "Hola Mundo");
    return model;
  }

	public static void main(String[] args) {
		SpringApplication.run(SeedApplication.class, args);
	}

}
