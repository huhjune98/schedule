package com.example.schedule.controller;


import com.example.schedule.dto.CreateEventRequestDto;
import com.example.schedule.dto.EventResponseDto;
import com.example.schedule.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    public ResponseEntity<EventResponseDto> save(@RequestBody CreateEventRequestDto requestDto) {

        EventResponseDto eventResponseDto = eventService.save(requestDto.getUsername(), requestDto.getTitle(), requestDto.getContents());


        return new ResponseEntity<>(eventResponseDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EventResponseDto>> findAll() {
        List<EventResponseDto> eventResponseDtoList = eventService.findAll();

        return new ResponseEntity<>(eventResponseDtoList, HttpStatus.OK);
    }
}
