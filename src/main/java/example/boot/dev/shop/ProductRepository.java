package example.boot.dev.shop;

import java.util.*;
import java.util.Optional;
import java.lang.String;

import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product,Integer> {
	
	List<Product> findByBrand(String brand);

	Optional <Product> findById(int id);

}


