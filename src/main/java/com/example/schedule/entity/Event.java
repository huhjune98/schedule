package com.example.schedule.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "event")
public class Event extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String title;

    private String contents;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

}
