package com.example.demo.cat;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Configuration
public class CatConfiguration {

    @Primary  // wskazanie, że w przypadku wielu implementacji tego interfejsu domyślnie wstrzyknięta zostanie poniższa
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)  // singleton i tak jest domyślny, ale tak się zmienia Scope'a, czyli
                                                     // kiedy tworzony jest nowy obiekt, a kiedy reużywany
    @Bean  // Bean'y to zależności - jest to drugi sposób ich tworzenia - za pomocą konfiguracji (klasa z adnotacją)
    public CatService catService() {                            // zamiast adnotacji Component nad klasą
        return new CatServiceImpl();
    }

    @Qualifier("catService2")  // nadanie nazwy dla zależności, dzięki której możemy wskazać, jaki Bean ma zostać wstrzynięty
    @Bean
    public CatService catService2() {
        return new CatServiceImpl2();
    }
}
