package mk.ecommerce.services;


import mk.ecommerce.entities.Product;

import java.util.List;

public interface IProductService {
  List<Product> showProducts();
  Product findProductById(Integer productId);
  List<Product> findProductsByCategoryId(Integer categoryId);
  List<Product> findRecentProducts(Integer startDate);
}
