
package com.mycompany.testwebapp.dao;

import com.google.common.collect.Lists;
import com.mycompany.testwebapp.users.User;
import com.mycompany.testwebapp.users.UserRepository;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author eguseynov
 */

/*
этот класс разительно отличается от реализации в примере с Hibernate
в оригинале он называется UserService
*/
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    
    /*
    этот объект дает доступ к CRUD методам для операций с объектом user, 
    а аннотация позволяет передавать этот объект между бинами
    */
    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
    
    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User findById(Integer id) { // ищет по id и возращает только для чтения
        return userRepository.findOne(id);
    }

    @Override
    @Transactional(readOnly = true) // ищет и возвращает только для чтения
    public List<User> findByLastName(String lastName) {
        return userRepository.findByLastName(lastName);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() { // ищет и возвращает только для чтения
        /*
        здесь встречаем класс Lists из com.google.common.collect.Lists,
        дающий доп.возможности классу объектам типа List
        */
        return Lists.newArrayList(userRepository.findAll());
    }

        
    
}
    

