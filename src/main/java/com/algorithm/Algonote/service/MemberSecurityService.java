package com.algorithm.Algonote.service;


import com.algorithm.Algonote.model.MemberEntity;
import com.algorithm.Algonote.model.MemberRole;
import com.algorithm.Algonote.repository.MemberRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberSecurityService implements UserDetailsService {

    private final MemberRepository memberRepository;
    @Override
    public UserDetails loadUserByUsername(String memberId) throws UsernameNotFoundException {
        Optional<MemberEntity> _member = this.memberRepository.findByMemberId(memberId);
        System.out.println(_member);

        if(_member.isEmpty()){
            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다");
        }

        MemberEntity member = _member.get();
        List<GrantedAuthority> authorities = new ArrayList<>();

        if("admin".equals(memberId)){
            authorities.add(new SimpleGrantedAuthority(MemberRole.AdMIN.getValue()));
        }else{
            authorities.add(new SimpleGrantedAuthority(MemberRole.USER.getValue()));
        }
        return new User(member.getMemberId(),member.getPassword(),authorities);


    }
}
