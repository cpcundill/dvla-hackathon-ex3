package main;

import config.DriverSearchConfig;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import resource.SearchDriverLocationResource;

import javax.servlet.DispatcherType;
import java.util.EnumSet;

public class App extends Application<DriverSearchConfig> {

    @Override
    public String getName() {
        return "driver-location-search";
    }

    @Override
    public void initialize(Bootstrap<DriverSearchConfig> bootstrap) {}

    @Override
    public void run(DriverSearchConfig config, Environment environment) throws Exception {
        environment.jersey().register(new SearchDriverLocationResource());
        //for cross-site resource calls
        environment.servlets().addFilter("cors-filter", CrossOriginFilter.class)
                .addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");
    }

    public static void main(String[] args) throws Exception {
        new App().run(args);
    }


}
