package com.example.schedule.dto;


import lombok.Getter;

@Getter
public class CreateEventRequestDto {

    private final String username;

    private final String title;

    private final String contents;

    public CreateEventRequestDto(String username, String title, String contents) {
        this.username = username;
        this.title = title;
        this.contents = contents;
    }
}
