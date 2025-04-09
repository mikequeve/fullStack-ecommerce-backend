package mk.ecommerce.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Category {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Integer categoryId;
  String name;

  @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
  @JsonManagedReference // Evita recursion infinita en el JSON
  @ToString.Exclude // Evita recursion infinita del metodo ToString
  List<Product> products;
}
