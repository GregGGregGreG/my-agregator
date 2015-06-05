package greg.aggregator.jba.repository;

import greg.aggregator.jba.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by greg on 05.06.15.
 */
public interface ItemRepository extends JpaRepository<Item, Integer> {
}
