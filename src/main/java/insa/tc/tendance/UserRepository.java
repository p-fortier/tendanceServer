package insa.tc.tendance;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * Created by Patrik on 05/06/2016.
 */

public interface UserRepository extends JpaRepository<User, Long>{
    User findByUsernameAndPassword(String username, String password);
    Collection<User> findByUsername(String username);
}
