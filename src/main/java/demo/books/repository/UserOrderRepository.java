package demo.books.repository;
import demo.books.entity.UserOrder;
import org.springframework.data.repository.CrudRepository;

public interface UserOrderRepository extends CrudRepository<UserOrder, Integer>{

}
