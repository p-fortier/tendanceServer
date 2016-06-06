package insa.tc.tendance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Patrik on 05/06/2016.
 */

@Transactional
public interface StyleRepository extends JpaRepository<Style,Long>{
}
