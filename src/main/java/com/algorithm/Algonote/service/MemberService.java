package com.algorithm.Algonote.service;


import com.algorithm.Algonote.model.MemberEntity;
import com.algorithm.Algonote.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public MemberEntity create(String memberId, String email, String password, String nickname){
        MemberEntity member = new MemberEntity();
        member.setMemberId(memberId);
        member.setEmail(email);
        member.setNickname(nickname);
        member.setPassword(passwordEncoder.encode(password));
        this.memberRepository.save(member);

        return member;
    }

}
