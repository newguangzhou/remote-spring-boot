package hello.models;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by server on 2017/5/16.
 */
@Transactional
public interface UserDao extends CrudRepository<User,Long> {
    public User findByEmail(String email);
    public User findByName(String name);
}
