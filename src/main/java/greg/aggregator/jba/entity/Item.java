package greg.aggregator.jba.entity;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by greg on 05.06.15.
 */
@Entity
@Data
@ToString(exclude = "blog")
public class Item {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(length = 1000)
    private String title;

    @Lob
    @Type(type = "org.hibernate.type.StringClobType")
    @Column(length = Integer.MAX_VALUE)
    private String description;

    @Column(name = "published_date")
    private Date publishedDate;

    @ManyToOne
    @JoinColumn(name = "blog_id")
    private Blog blog;

    @Column(length = 1000)
    private String link;

}
