package com.project.easyEvent.event.model.repository;

import com.project.easyEvent.event.model.entity.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Integer> {

    List<Participant> findByNameAndEmailAndIsUser(String name, String email, Boolean isUser);
}
