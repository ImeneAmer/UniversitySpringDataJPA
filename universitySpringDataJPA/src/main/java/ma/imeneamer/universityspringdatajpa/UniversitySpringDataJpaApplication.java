package ma.imeneamer.universityspringdatajpa;

import ma.imeneamer.universityspringdatajpa.entities.Product;
import ma.imeneamer.universityspringdatajpa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class UniversitySpringDataJpaApplication implements CommandLineRunner {
   @Autowired
    private ProductRepository pr;

    public static void main(String[] args) {

        SpringApplication.run(UniversitySpringDataJpaApplication.class, args);


    }

    @Override
    public void run(String... args) throws Exception {
  pr.save(new Product(null,"computer",4500,3));
  pr.save(new Product(null,"pc",5000,5));
  List<Product> productList =pr.findAll();
  productList.forEach(p->{
      System.out.println(p.toString());
  });
  Product product =pr.findById(Long.valueOf(1)).get();
        System.out.println("****************");
        System.out.println(product.getId());
        System.out.println(product.getNom());
        System.out.println(product.getQte());
        System.out.println("****************");
        List<Product> productList1=pr.findByNomContains("pc");
        productList1.forEach(p->{
            System.out.println(p);
        });
        System.out.println("*******************");

        List<Product> productList2=pr.search("%computer%");
        productList2.forEach(p->{
            System.out.println(p);
        });

        System.out.println("*******************");

        List<Product> productList3=pr.findByPriceGreaterThan(2000);
        productList3.forEach(p->{
            System.out.println(p);
        });

    }
}
