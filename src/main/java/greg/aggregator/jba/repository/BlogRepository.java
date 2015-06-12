package greg.aggregator.jba.repository;

import greg.aggregator.jba.entity.Blog;
import greg.aggregator.jba.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

/**
 * Created by greg on 05.06.15.
 */
public interface BlogRepository extends JpaRepository<Blog,Integer> {

    Set<Blog> findByUser(User user);
}
