package com.immutestable.dvdrental.users.infrastructure;

import com.immutestable.dvdrental.users.domain.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.core.mapping.RepositoryDetectionStrategy;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class DataRestConfig implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        config.setRepositoryDetectionStrategy(
                RepositoryDetectionStrategy.RepositoryDetectionStrategies.ANNOTATED);

        config.getExposureConfiguration()
                .forDomainType(User.class)
                .withItemExposure((metaData, httpMethods) -> httpMethods.disable(HttpMethod.PUT, HttpMethod.DELETE))
                .withCollectionExposure((metaData, httpMethods) -> httpMethods.disable(HttpMethod.PUT, HttpMethod.DELETE));
    }


}