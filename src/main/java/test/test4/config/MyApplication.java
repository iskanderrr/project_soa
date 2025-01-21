package test.test4.config;

import org.glassfish.jersey.server.ResourceConfig;
import jakarta.ws.rs.ApplicationPath;

@ApplicationPath("/webapi") // Base URI for all resources
public class MyApplication extends ResourceConfig {
    public MyApplication() {
        // Scan for JAX-RS resources and providers in specified package(s)
        packages("test.test4");
        // Register additional features or components, if any
        // register(SomeFeature.class);
    }
}
