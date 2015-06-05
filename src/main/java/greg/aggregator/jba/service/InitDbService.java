package greg.aggregator.jba.service;

import greg.aggregator.jba.entity.Blog;
import greg.aggregator.jba.entity.Item;
import greg.aggregator.jba.entity.Role;
import greg.aggregator.jba.entity.User;
import greg.aggregator.jba.repository.BlogRepository;
import greg.aggregator.jba.repository.ItemRepository;
import greg.aggregator.jba.repository.RoleRepository;
import greg.aggregator.jba.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by greg on 05.06.15.
 */
@Transactional
@Service
public class InitDbService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private ItemRepository itemRepository;

    @PostConstruct
    public void init() {
        Role roleUser = new Role();
        roleUser.setName("ROLE_USER");
        roleRepository.save(roleUser);

        Role roleAdmin = new Role();
        roleUser.setName("ROLE_ADMIN");
        roleRepository.save(roleAdmin);

        User userAdmin = new User();
        userAdmin.setName("admin");
        List<Role> roles = new ArrayList<Role>();
        roles.add(roleAdmin);
        roles.add(roleUser);
        userAdmin.setRoles(roles);
        userRepository.save(userAdmin);

        Blog blogJavaVids = new Blog();
        blogJavaVids.setName("JavaVids");
        blogJavaVids.setUrl("http://feeds.feedburner.com/javavids?format=xml");
        blogJavaVids.setUser(userAdmin);
        blogRepository.save(blogJavaVids);

        Item item1 = new Item();
        item1.setBlog(blogJavaVids);
        item1.setTitle("first");
        item1.setLink("http://www.javavids.com");
        item1.setPublishedDate(new Date());
        itemRepository.save(item1);

        Item item2 = new Item();
        item2.setBlog(blogJavaVids);
        item2.setTitle("second");
        item2.setLink("http://www.javavids.com");
        item2.setPublishedDate(new Date());
        itemRepository.save(item2);



    }


}
