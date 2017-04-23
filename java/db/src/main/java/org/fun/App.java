package org.fun;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;
import org.fun.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.fun.repository.UserRepository;

import java.util.Map;

/*
 * This Java source file was generated by the Gradle 'init' task.
 */
@SpringBootApplication
@ComponentScan(basePackages = "org.fun")
public class App implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ObjectMapper json;

    public static void main(String[] args) {
        SpringApplication authApplication = new SpringApplication(App.class);
        authApplication.setBannerMode(Banner.Mode.OFF);
        authApplication.run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        Map<String, String> name = Maps.newHashMap();
        name.put("first_name", "Timur");
        name.put("last_name", "Nasibullin");
        Map<String, String> address = Maps.newHashMap();
        address.put("city", "SPb");
        User me = User.builder()
                .userName("tim")
                .password((bcrypt.encode("tim")))
                .name(json.writeValueAsString(name))
                .address(json.writeValueAsString(address))
                .email("timur.nasibullin@gmail.com")
                .build();
        userRepository.save(me);
    }
}
