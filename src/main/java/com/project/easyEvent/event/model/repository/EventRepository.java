package com.project.easyEvent.event.model.repository;

import com.project.easyEvent.event.model.entity.Event;
import com.project.easyEvent.user.model.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {

    List<Event> findByProducer(Users producer);
}
