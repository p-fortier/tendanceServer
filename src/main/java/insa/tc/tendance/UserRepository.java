package insa.tc.tendance;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Patrik on 05/06/2016.
 */

@Transactional
public interface UserRepository extends JpaRepository<User, Long>{
    User findByUsernameAndPassword(String username, String password);
    Collection<User> findByUsername(String username);
    List<User> findAll();
    User getFriendsIdById(long id);
    User getById(long id);
}
