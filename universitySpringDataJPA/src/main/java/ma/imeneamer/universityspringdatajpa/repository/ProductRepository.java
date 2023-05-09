package ma.imeneamer.universityspringdatajpa.repository;

import ma.imeneamer.universityspringdatajpa.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> findByNomContains(String mc);
    List<Product> findByPriceGreaterThan(double price);

    @Query("select p from Product p where p.nom like :x")
    List<Product> search(@Param("x") String mc);
}
