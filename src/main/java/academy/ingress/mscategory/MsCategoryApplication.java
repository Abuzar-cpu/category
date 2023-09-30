package academy.ingress.mscategory;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MsCategoryApplication {

  public static void main(String[] args) {
    SpringApplication.run(MsCategoryApplication.class, args);
  }

  @PostConstruct
  public void test() {
    System.out.println("Hola mundo");
  }
}
