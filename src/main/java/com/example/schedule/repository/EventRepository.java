package com.example.schedule.repository;

import com.example.schedule.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public interface EventRepository extends JpaRepository<Event, Long> {

    default Event findByIdOrElseThrow(Long id) {
        return findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "존재하지 않는 id : "+ id));
    }
}
