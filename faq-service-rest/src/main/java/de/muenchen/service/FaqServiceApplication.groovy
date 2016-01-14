package de.muenchen.service

import de.muenchen.service.repo.FaqRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.filter.ShallowEtagHeaderFilter

import javax.servlet.Filter

@SpringBootApplication
class FaqServiceApplication {

    @Bean(initMethod = "loadData")
    public FaqDataLoader RepositoryTestData(){
        return new FaqDataLoader();
    }

    @Bean
    public Filter shallowEtagHeaderFilter() {
        return new ShallowEtagHeaderFilter();
    }

    static void main(String[] args) {
        SpringApplication.run FaqServiceApplication, args
    }
}
