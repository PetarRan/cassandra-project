package petarran.springframework.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import petarran.springframework.domain_model.User;
import petarran.springframework.repositories.CartRepository;
import petarran.springframework.repositories.ProductRepository;
import petarran.springframework.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;


    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public List<User> listAll() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void update(User product) {

    }

    @Override
    public void save(User user) {
        if(userRepository.findByUsername(user.getUserId()) == null){
            userRepository.save(user);
        }
    }

    @Override
    public void deleteProduct(User product) {

    }
}
