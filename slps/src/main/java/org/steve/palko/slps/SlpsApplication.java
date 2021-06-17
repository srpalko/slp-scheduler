package org.steve.palko.slps;

import com.google.maps.GeoApiContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
public class SlpsApplication {
    public static void main(String[] args) {
        SpringApplication.run(SlpsApplication.class, args);
    }
}
