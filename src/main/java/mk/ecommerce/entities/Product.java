package mk.ecommerce.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Integer productId;
  String name;
  String imgUrl;
  Double price;
  String[] size;
  LocalDateTime createdAt;

  @ManyToOne
  @JoinColumn(name = "category_id", nullable = false)
  @JsonBackReference // Evita recursion infinita en el JSON
  @ToString.Exclude // Evita recursion infinita del metodo ToString
  Category category;
}
