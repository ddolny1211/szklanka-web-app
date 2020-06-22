package webddapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import webddapp.data.UserRepository;
import webddapp.data.UserRoleRepository;
import webddapp.model.User;
import webddapp.model.UserRole;

@Service
public class UserService {

    private static final String DEFAULT_ROLE="ROLE_USER";
    private UserRepository userRepository;
    private UserRoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(PasswordEncoder passwordEncoder){
        this.passwordEncoder=passwordEncoder;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setRoleRepository(UserRoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public void addUserWithDefaultRole(User user){
        UserRole defaultRole = roleRepository.findByRole(DEFAULT_ROLE);
        user.getRoles().add(defaultRole);
        String passwordHash = passwordEncoder.encode(user.getPassword());
        user.setPassword(passwordHash);
        userRepository.save(user);
    }
}
