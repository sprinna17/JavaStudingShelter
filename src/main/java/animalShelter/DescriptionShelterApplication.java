package animalShelter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.hibernate.autoconfigure.HibernateJpaAutoConfiguration;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication(
// INC temporalmente -> sin base de datos
        exclude = {
                DataSourceAutoConfiguration.class,
                HibernateJpaAutoConfiguration.class
        }
)
// FIN temporalmente -> sin base de datos
public class DescriptionShelterApplication {

    public static void main(String[] args) {
        SpringApplication.run(DescriptionShelterApplication.class, args);
    }

}
