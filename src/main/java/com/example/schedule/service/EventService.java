package com.example.schedule.service;

import com.example.schedule.dto.EventResponseDto;
import com.example.schedule.entity.Event;
import com.example.schedule.entity.Member;
import com.example.schedule.repository.EventRepository;
import com.example.schedule.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

}
