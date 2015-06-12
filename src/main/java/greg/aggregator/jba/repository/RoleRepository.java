package greg.aggregator.jba.repository;

import greg.aggregator.jba.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by greg on 05.06.15.
 */
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findByName(String name);
}
