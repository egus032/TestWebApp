
package com.mycompany.testwebapp.users;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 *
 * @author eguseynov
 */
/*
таким образом, получаем доступ к методам наследуемого интерфейса
без проблем, дополнительно пишем свой метод (совпадает полностью с методом
класса DaoInterface)
*/
@Repository
public interface UserRepository extends CrudRepository <User, Integer> {
    public List<User> findByLastName(String lastName);
}