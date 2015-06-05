package greg.aggregator.jba.repository;

import greg.aggregator.jba.entity.Blog;
import greg.aggregator.jba.entity.Item;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by greg on 05.06.15.
 */
public interface ItemRepository extends JpaRepository<Item, Integer> {

    List<Item> findByBlog(Blog blog, Pageable pageable);
}
