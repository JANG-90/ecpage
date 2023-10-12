package com.example.ecpage.dto;

import com.example.ecpage.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
@ToString
@AllArgsConstructor
@Getter
public class MemberForm {


    private Long id;
    private String memberEmail;
    private String memberPassword;
    private String memberName;

    public Member toEntity(){

        return new Member(id,memberEmail,memberPassword,memberName);
    }
}
