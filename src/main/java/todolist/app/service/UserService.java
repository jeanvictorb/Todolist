package todolist.app.service;

import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import todolist.app.entity.User;
import todolist.app.repository.UserRepository;

@Service
public class UserService {
    
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
    }


    
    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new RuntimeException("user não encontrado!");
        }
        if (user.get().getSenha().isEmpty()) {
        user.get().setSenha("12345");
        }
        return user.get();
    }

    public User findByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isEmpty()) {
            throw new RuntimeException("Usuário com esse email não encontrado!");
        }
        return user.get();
    }

    public User postMapping(User user) {
        User post = userRepository.save(user);
        return post;

    }

    public ResponseEntity<Void> deleteMapping(Long id) {

        if (!userRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        userRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    public User putMapping(User user) {
        User put = userRepository.save(user);
        return put;
    }

}
