package mk.ecommerce.repositories;

import mk.ecommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
  @Query("SELECT p FROM Product p INNER JOIN p.category c WHERE c.categoryId = :categoryId")
  List<Product> findByCategoryCategoryId(@Param("categoryId") Integer categoryId);

  @Query("SELECT p FROM Product p WHERE p.createdAt >= :startDate ORDER BY p.createdAt DESC")
  List<Product> findRecentProducts(@Param("startDate") LocalDateTime startDate);
}
