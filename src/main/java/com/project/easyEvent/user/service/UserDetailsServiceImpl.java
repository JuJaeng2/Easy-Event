package com.project.easyEvent.user.service;

import com.project.easyEvent.common.exception.CustomException;
import com.project.easyEvent.common.exception.ErrorCode;
import com.project.easyEvent.user.model.entity.Users;
import com.project.easyEvent.user.model.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsersRepository usersRepository;

    public UserDetails loadUserByEmail(String email) throws UsernameNotFoundException{
        return loadUserByUsername(email);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Users user = usersRepository.findByEmail(email)
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));

        return (UserDetails) Users.builder()
                .name(user.getName())
                .id(user.getId())
                .email(user.getEmail())
                .phone(user.getPhone())
                .id(user.getId())
                .isDeleted(user.getIsDeleted())
                .password(user.getPassword())
                .build();
    }

}
