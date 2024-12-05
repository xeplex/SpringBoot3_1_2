package ru.umnikov.spring.spring_springboot.SpringBoot3_1_2.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.umnikov.spring.spring_springboot.SpringBoot3_1_2.dao.UserRepository;
import ru.umnikov.spring.spring_springboot.SpringBoot3_1_2.model.User;


import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public User getById(int id) {
        return userRepository.findById(id).isPresent() ?
                userRepository.findById(id).get() :
                null;
    }

    @Override
    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void delete(int id) {
        userRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void update(User user, int id) {
        User existingUser = getById(id);
        existingUser.setName(user.getName());
        existingUser.setSurname(user.getSurname());
        existingUser.setBirthYear(user.getBirthYear());
        existingUser.setHeight(user.getHeight());
        existingUser.setWeight(user.getWeight());
    }
}
