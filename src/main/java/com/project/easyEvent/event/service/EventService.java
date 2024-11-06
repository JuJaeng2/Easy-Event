package com.project.easyEvent.event.service;

import com.project.easyEvent.event.model.dto.EventIdTitle;
import com.project.easyEvent.event.model.dto.EventInfo;
import com.project.easyEvent.event.model.dto.ParticipatedEvent;
import com.project.easyEvent.event.model.entity.Event;
import com.project.easyEvent.event.model.entity.Participant;
import com.project.easyEvent.event.model.repository.EventRepository;
import com.project.easyEvent.event.model.repository.ParticipantRepository;
import com.project.easyEvent.user.model.entity.Users;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EventService {

    private final EventRepository eventRepository;
    private final ParticipantRepository participantRepository;

    /*

     */

    /*
    생성한 이벤트 조회
     */
    public List<EventInfo> getEventIdTitleList(Users producer) {
        return eventRepository.findByProducer(producer).stream()
                .map(EventInfo::from)
                .toList();
    }

    /*
    회원일 때 참여한 이벤트 관련 정보 조회
    */
    public List<ParticipatedEvent> getParticipatedEeventList(Users participant) {
        return getparticipatedEvnetList(participant.getName(), participant.getEmail(), true);
    }


    public List<ParticipatedEvent> getparticipatedEvnetList(String name, String email, Boolean isUser) {
        return participantRepository.findByNameAndEmailAndIsUser(name, email, isUser).stream()
                .map(ParticipatedEvent::from)
                .toList();

    }

}
