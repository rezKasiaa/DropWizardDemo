import DAO.BrandDAO;
import healthCheck.TemplateHealthCheck;
import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;
import resources.BrandResource;
import resources.HelloWorldResources;

public class HelloWorldApplication extends Application<HelloWorldConfiguration> {
    public static void main(String[] args) throws Exception {
        new HelloWorldApplication().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(HelloWorldConfiguration configuration,
                    Environment environment) {
        final HelloWorldResources resource = new HelloWorldResources(
                configuration.getTemplate(),
                configuration.getDefaultName()
        );
//        final DBIFactory factory = new DBIFactory();
//        final DBI jdbi = factory.build(environment, HelloWorldConfiguration.getDataSourceFactory(),
//                "postgresql");

 //       final BrandDAO brandDao = jdbi.onDemand(BrandDAO.class);

        final TemplateHealthCheck healthCheck =
                new TemplateHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);
        environment.jersey().register(resource);
       // environment.jersey().register(new BrandResource(brandDao));

//        new BrandResource(brandDao).createTable();
    }
}