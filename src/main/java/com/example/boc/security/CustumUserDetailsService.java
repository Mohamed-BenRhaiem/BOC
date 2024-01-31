package com.example.boc.security;

import com.example.boc.Dao.EmployeDao;
import com.example.boc.model.Employe;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustumUserDetailsService implements UserDetailsService {
    @Autowired
    private final EmployeDao employeDao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("username{}",username);
        Optional<Employe> employe = employeDao.findByNomemp(username);
        employe.orElseThrow(()->new UsernameNotFoundException("user not found"));
        log.info("Password{}",employe.get().getPassword());
        String password = employe.get().getPassword();

        String role = employe.get().getRole();
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(role));
        log.info("Role{}",role);

        return new CustumUserDetails(username,password,roles);
    }
}
