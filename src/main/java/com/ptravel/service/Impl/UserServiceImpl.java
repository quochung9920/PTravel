package com.ptravel.service.Impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.ptravel.pojos.User;
import com.ptravel.repository.UserRepository;
import com.ptravel.service.UserService;

@Service("userDetailsService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private Cloudinary cloudinary;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    private static String UPLOADED_FOLDER = "C://Users//quoch//Desktop//ptravel//src//main//webapp//resources//images//avartar//";


    @Override
    public List<User> getUsers(String email) {
        return this.userRepository.getUsers(email);
    }

    @Override
    public boolean addUser(User user, String role) {
        
        String pass = user.getPassword();
        user.setPassword(this.passwordEncoder.encode(pass));
        user.setUserRole(role);
        return this.userRepository.addUser(user);
    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<User> users = this.getUsers(username);
        if (users.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }
        User user = users.get(0);
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(user.getUserRole()));
        
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
    }

    @Override
    public List<User> getListUsers() {
        return this.userRepository.getListUsers();
    }

    @Override
    public User updateUser(int userId, User user) {

        user.setPassword(this.passwordEncoder.encode(user.getPassword()));

        return this.userRepository.updateUser(user, userId);
    }

    @Override
    public User getUserById(int id) {
        return this.userRepository.getUserById(id);
    }

    @Override
    public boolean updateAvatar(int userId, MultipartFile avatar) {
            // if (avatar.isEmpty()) {
            //     continue; //next pls
            // }

            try {

                byte[] bytes = avatar.getBytes();
                Path path = Paths.get(UPLOADED_FOLDER + avatar.getOriginalFilename());
                Files.write(path, bytes);

                return this.userRepository.updateAvatar(userId, avatar.getOriginalFilename());
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
    }

 


}
