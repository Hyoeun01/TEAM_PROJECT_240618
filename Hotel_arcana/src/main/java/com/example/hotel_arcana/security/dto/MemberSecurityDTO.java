package com.example.hotel_arcana.security.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.Map;

@Getter
@Setter
@ToString
//extends는 MemberSecurityDTO가 User를 상속받고 있음을 의미
public class MemberSecurityDTO extends User {
    //멤버 변수 설정
    private String USER_ID;
    private String USER_PW;
    private String USER_NM;
    private String USER_ADR;
    private String USER_EML;
    private String USER_TEL;
    private String USER_NIK;

//    private Map<String, Object> props;

    //생성자 : MemberSecurityDTO 객체를 만들기 위해 생성
    //생성자 안 만들면 기본 생성자 private Member = new member(); 형태의  기본생성자 생김
    public MemberSecurityDTO(String USER_ID,
                             String USER_PW,
                             String USER_NM,
                             String USER_ADR,
                             String USER_EML,
                             String USER_TEL,
                             String USER_NIK,
                             Collection<? extends GrantedAuthority> authorities)
    {
        //super는 부모 클래스의 생성자를 부르는 것 여기서는 User의 생성자 부름
        super(USER_ID, USER_PW, authorities);

        //객체 안의 멤버 변수에 각각의 데이터 설정부분
        this.USER_ID = USER_ID;
        this.USER_PW = USER_PW;
        this.USER_NM = USER_NM;
        this.USER_ADR = USER_ADR;
        this.USER_EML = USER_EML;
        this.USER_NIK = USER_NIK;
        this.USER_TEL = USER_TEL;
    }

//    @Override
//    public Map<String, Object> getAttributes() {
//        return this.props;
//    }
//
//    @Override
//    public String getName(){
//        return this.USER_ID;
//    }
}
