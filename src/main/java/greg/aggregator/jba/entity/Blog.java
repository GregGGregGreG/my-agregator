package greg.aggregator.jba.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by greg on 05.06.15.
 */
@Entity
@Data
public class Blog {

    @Id
    @GeneratedValue
    private Integer id;

    private String url;

    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "blog")
    private List<Item> items;
}
