package com.immutestable.dvdrental.movies.infrastructure;

import com.immutestable.dvdrental.movies.domain.MovieFacade;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MovieFacadeBuilder {


    @Bean
    public MovieFacade movieFacade() {
        return new MovieFacade(null);
    }

}
