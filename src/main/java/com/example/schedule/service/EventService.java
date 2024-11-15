package com.example.schedule.service;

import com.example.schedule.dto.EventResponseDto;
import com.example.schedule.dto.MemberResponseDto;
import com.example.schedule.entity.Event;
import com.example.schedule.entity.Member;
import com.example.schedule.repository.EventRepository;
import com.example.schedule.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {

    private final MemberRepository memberRepository;
    private final EventRepository eventRepository;

    public EventResponseDto save(String username, String title, String content) {

        Member findMember = memberRepository.findMemberByUsernameOrElseThrow(username);

        Event event = new Event(title, content);
        event.setMember(findMember);

        eventRepository.save(event);

        return new EventResponseDto(event.getId(), event.getUsername(), event.getTitle(), event.getContents());

    }

    public List<EventResponseDto> findAll() {
        return eventRepository.findAll()
                .stream()
                .map(EventResponseDto::toDto)
                .toList();
    }

    public MemberResponseDto findMemberById(Long id) {
        Event findEvent = eventRepository.findByIdOrElseThrow(id);
        Member writer = findEvent.getMember();

        return new MemberResponseDto(findEvent.getUsername(), findEvent.getTitle());
    }

    public void delete(Long id) {

        Event findEvent = eventRepository.findByIdOrElseThrow(id);

        eventRepository.delete(findEvent);
    }

}
