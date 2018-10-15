package com.grydtech.msstack.core;

import com.grydtech.msstack.configuration.ApplicationConfiguration;
import com.grydtech.msstack.util.ConfigurationInjectorUtils;
import com.grydtech.msstack.util.DependencyInjectorUtils;
import com.grydtech.msstack.util.YamlConverter;

import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class with static start method that can be used to start a microservice
 */
@SuppressWarnings("unused")
public final class MicroserviceRunner {

    private static final Logger LOGGER = Logger.getLogger(MicroserviceRunner.class.toGenericString());

    private MicroserviceRunner() {
    }

    public static void run(Class<? extends MicroserviceApplication> applicationClass) throws Exception {
        // Inject dependencies from classpath
        InputStream configFileStream = applicationClass.getClassLoader().getResourceAsStream("application.yml");
        ApplicationConfiguration applicationConfiguration = YamlConverter.getObject(configFileStream, ApplicationConfiguration.class).orElseThrow(RuntimeException::new);

        ConfigurationInjectorUtils.putValueObject("applicationConfiguration", applicationConfiguration);
        ConfigurationInjectorUtils.inject();
        DependencyInjectorUtils.inject();

        LOGGER.log(Level.ALL, "Starting application...");
        // Start Application
        applicationClass.newInstance().start();
        LOGGER.log(Level.ALL, "MicroserviceApplication Started.");
    }
}
