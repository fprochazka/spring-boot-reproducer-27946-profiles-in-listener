package com.fprochazka.springBootReproducer;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;

public class SpringCloudBootstrapOverridesListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent>, Ordered
{

    /**
     * This listener is meant to affect Spring Cloud, so I want it to have higher precedence.
     * I was originally using org.springframework.cloud.bootstrap.BootstrapApplicationListener#DEFAULT_ORDER here,
     * but that dependency is not relevant for the reproducer.
     */
    public static final int LISTENER_ORDER = (Ordered.HIGHEST_PRECEDENCE + 5) - 1;

    @Override
    public void onApplicationEvent(final ApplicationEnvironmentPreparedEvent event)
    {
        ConfigurableEnvironment environment = event.getEnvironment();
        String[] activeProfiles = environment.getActiveProfiles();

        System.out.printf("I expect here [web, production] and was given [%s]%n", String.join(", ", activeProfiles));
    }

    @Override
    public int getOrder()
    {
        return LISTENER_ORDER;
    }

}
