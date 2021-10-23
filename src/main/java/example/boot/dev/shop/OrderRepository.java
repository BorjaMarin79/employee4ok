package example.boot.dev.shop;

import org.springframework.data.repository.CrudRepository;


public interface OrderRepository extends CrudRepository<OrderService,Integer>{
}