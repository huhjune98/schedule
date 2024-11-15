package com.example.schedule.service;

import com.example.schedule.dto.LoginRequestDto;
import com.example.schedule.dto.MemberResponseDto;
import com.example.schedule.dto.SignUpResponseDto;
import com.example.schedule.entity.Member;
import com.example.schedule.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;


    public SignUpResponseDto signUp(String username, String email, String password ) {

        Member member = new Member(username, email, password);

        Member savedMember = memberRepository.save(member);

        return new SignUpResponseDto(savedMember.getId(), savedMember.getUsername(), savedMember.getEmail());

    }

    public MemberResponseDto findById(Long id) {

        Optional<Member> optionalMember = memberRepository.findById(id);

        if(optionalMember.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "존재하지 않는 ID ; "+id);
        }

        Member findMember= optionalMember.get();

        return new MemberResponseDto(findMember.getUsername(), findMember.getEmail());


    }

    public void delete(Long id) {

        Member findMember = memberRepository.findByUserIdOrElseThrow(id);

        memberRepository.delete(findMember);

    }

    public Member loginUser(LoginRequestDto loginRequestDto) {

        Member member = memberRepository.findByEmail(loginRequestDto.getEmail());

        if(member == null ||!Objects.equals(member.getPassword(),loginRequestDto.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "유효하지 않은 이메일 또는 잘못된 비밀번호");
        }
        return member;
    }
}
