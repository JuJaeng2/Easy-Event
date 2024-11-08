package com.project.easyEvent.user.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.easyEvent.common.exception.CustomException;
import com.project.easyEvent.common.exception.ErrorCode;
import com.project.easyEvent.common.utils.PasswordEncoderUtil;
import com.project.easyEvent.event.model.dto.EventInfo;
import com.project.easyEvent.event.model.dto.ParticipatedEvent;
import com.project.easyEvent.event.service.EventService;
import com.project.easyEvent.user.model.dto.SignUpForm;
import com.project.easyEvent.user.model.dto.UserDetailResponse;
import com.project.easyEvent.user.model.entity.Users;
import com.project.easyEvent.user.model.repository.UsersRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UsersRepository usersRepository;
    private final EventService eventService;
    private final PasswordEncoderUtil passwordEncoderUtil;

    /*
     * 회원가입
     */
    @Transactional
    public void signUp(SignUpForm signUpForm) {
        if (usersRepository.existsByEmail(signUpForm.getEmail())) {
            throw new CustomException(ErrorCode.EMAIL_ALREADY_EXIST);
        }

        Users newUser = Users.makeNewUser(signUpForm);
        passwordEncoderUtil.encode(newUser); // password 암호화
        usersRepository.save(newUser);
    }

    public UserDetailResponse getUserInfo(Integer id) {

        Users user = usersRepository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));

        List<EventInfo> eventIdTitles = eventService.getEventIdTitleList(user);
        List<ParticipatedEvent> participatedEvents = eventService.getParticipatedEeventList(user);

        return UserDetailResponse.from(user, eventIdTitles, participatedEvents);
    }
}
