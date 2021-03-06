import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

/*
 * This Java source file was generated by the Gradle 'init' task.
 */
public class App extends Application<AppConfiguration> {

    public static void main(String[] args) throws Exception {
        new App().run(args);
    }

    @Override
    public void run(AppConfiguration configuration, Environment environment) throws Exception {
        final UserResource userResource = new UserResource();
        userResource.setDataSource(new DummyData());
        environment.jersey().register(userResource);

        final AppHealthCheck healthCheck = new AppHealthCheck();
        environment.healthChecks().register("app", healthCheck);
    }
}
