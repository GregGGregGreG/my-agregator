package greg.aggregator.jba.service;

import greg.aggregator.jba.entity.Blog;
import greg.aggregator.jba.entity.Item;
import greg.aggregator.jba.entity.User;
import greg.aggregator.jba.execption.RssException;
import greg.aggregator.jba.repository.BlogRepository;
import greg.aggregator.jba.repository.ItemRepository;
import greg.aggregator.jba.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by greg on 12.06.15.
 */
@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RssService rssService;

    @Autowired
    private ItemRepository itemRepository;

    public void saveItems(Blog blog) {
        try {
            List<Item> items = rssService.getItems(blog.getUrl());
            for (Item item : items) {
                Item saveItem = itemRepository.findByBlogAndLink(blog, item.getLink());
                if (saveItem == null) {
                    item.setBlog(blog);
                    itemRepository.save(item);
                }
            }
        } catch (RssException e) {
            e.printStackTrace();
        }
    }

    // 1 hour = 60 second * 60 minute * 1000
    @Scheduled(fixedDelay = 3600000)
    public void reloadBlogs() {
        List<Blog> blogs = blogRepository.findAll();
        for (Blog blog : blogs) {
            saveItems(blog);
        }
    }

    public void save(Blog blog, String name) {
        User user = userRepository.findByName(name);
        blog.setUser(user);
        blogRepository.save(blog);
        saveItems(blog);
    }

    @PreAuthorize("#blog.user.name == authentication.name or hasRole('ROLE_ADMIN')")
    public void delete(@P("blog") Blog blog) {
        blogRepository.delete(blog);
    }

    public Blog findOne(int id) {

        return blogRepository.findOne(id);
    }
}
