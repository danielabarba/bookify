package demo.books.Repository;
import demo.books.Entity.UserOrder;
import org.springframework.data.repository.CrudRepository;

public interface UserOrderRepository extends CrudRepository<UserOrder, Integer>{

}
