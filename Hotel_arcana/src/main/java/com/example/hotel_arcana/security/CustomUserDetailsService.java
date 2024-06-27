package com.example.hotel_arcana.security;

import com.example.hotel_arcana.login.dto.MemberDTO;
import com.example.hotel_arcana.login.mapper.MemberMapper;
import com.example.hotel_arcana.security.dto.MemberSecurityDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Log4j2
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberMapper memberMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("loadUserByUsername : " + username);

        //데이터베이스에서 username으로 검색한 회원정보를 취득
        MemberDTO memberDTO = memberMapper.findMemberById(username);

        //회원정보 유무를 확인하는 if문
        if(memberDTO.isEmpty()){
            //isEmpty 비어있으면 UsernameNotFoundException 예외처리 후 진행 안 됨
            throw new UsernameNotFoundException("username not found...");
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_"+memberDTO.getUSER_AUTH()));
        if(memberDTO.getUSER_AUTH().equals("ADMIN")){
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        }
        //Member객체를 MemberSecurityDTO객체로 변환
        MemberSecurityDTO memberSecurityDTO =
                new MemberSecurityDTO(
                        memberDTO.getUSER_ID(),
                        memberDTO.getUSER_PW(),
                        memberDTO.getUSER_EML(),
                        memberDTO.getUSER_NM(),
                        memberDTO.getUSER_ADR(),
                        memberDTO.getUSER_TEL(),
                        memberDTO.getUSER_NIK(),

                        authorities
                        );

        log.info("memberSecurityDTO");
        log.info(memberSecurityDTO);

        return memberSecurityDTO;


    }
}
