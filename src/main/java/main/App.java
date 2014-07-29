package main;

import config.DriverSearchConfig;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import resource.SearchDriverLocationResource;

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
    }

    public static void main(String[] args) throws Exception {
        new App().run(args);
    }


}
