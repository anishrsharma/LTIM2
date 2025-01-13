<<<<<<< HEAD

package com.wecp.progressive.service;

import com.wecp.progressive.entity.Supplier;
import com.wecp.progressive.exception.SupplierAlreadyExistsException;
import com.wecp.progressive.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LoginService implements UserDetailsService {

    private final SupplierRepository supplierRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public LoginService(SupplierRepository supplierRepository, PasswordEncoder passwordEncoder) {
        this.supplierRepository = supplierRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<Supplier> getAllUsers() {
        return supplierRepository.findAll();
    }

    public Optional<Supplier> getUserById(Integer userId) {
        return supplierRepository.findById(userId);
    }

    public Supplier getSupplierByName(String username) {
        return supplierRepository.findByUsername(username);
    }

    public Supplier createUser(Supplier user) {
        Supplier oldUser = supplierRepository.findByUsername(user.getUsername());
        if (oldUser != null) {
            throw new SupplierAlreadyExistsException("User name Is Unavailable: " + user.getUsername());

        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return supplierRepository.save(user);
    }

    public Supplier updateUser(Supplier user) {
        return supplierRepository.save(user);
    }

    public void deleteUser(Integer id) {
        supplierRepository.deleteBySupplierId(id);
=======
package com.wecp.progressive.service;

import com.wecp.progressive.entity.Supplier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public class LoginService implements UserDetailsService {

    public List<Supplier> getAllUsers() {
        return null;
    }

    public Optional<Supplier> getUserById(Integer userId) {
        return null;
    }

    public Supplier getSupplierByName(String username) {
        return null;
    }

    public Supplier createUser(Supplier user) {
        return null;
    }

    public Supplier updateUser(Supplier user) {
        return null;
    }

    public void deleteUser(Integer id) {
>>>>>>> 8acc72b1e911af2c02e73ead4a2d075d54614ca9
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
<<<<<<< HEAD
        Supplier user = supplierRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                new ArrayList<>()
        );
    }
}
=======
        return null;
    }
}
>>>>>>> 8acc72b1e911af2c02e73ead4a2d075d54614ca9
