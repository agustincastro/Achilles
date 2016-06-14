package uy.edu.ort.achilles.ws.config;

import java.util.Set;
import javax.ws.rs.core.Application;


@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(uy.edu.ort.achilles.ws.admin.ArticleResource.class);
        resources.add(uy.edu.ort.achilles.ws.admin.ShippingStatusResource.class);
        resources.add(uy.edu.ort.achilles.ws.carrier.CarrierResource.class);
        resources.add(uy.edu.ort.achilles.ws.client.ClientResource.class);
    }
}
