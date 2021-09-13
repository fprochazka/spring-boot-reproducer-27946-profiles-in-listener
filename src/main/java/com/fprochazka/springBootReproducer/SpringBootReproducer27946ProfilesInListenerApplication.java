package com.fprochazka.springBootReproducer;

import org.springframework.boot.Banner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootReproducer27946ProfilesInListenerApplication
{

    public static void main(String[] args)
    {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(SpringBootReproducer27946ProfilesInListenerApplication.class)
            .registerShutdownHook(true)
            .bannerMode(Banner.Mode.OFF)
            .web(WebApplicationType.SERVLET)
            .profiles("web") // additional profiles
            .run(args);

        context.close();
    }

}
