package com.example.timeline.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor // 기본생성자를 만든다.
@Getter
@Entity  // 테이블과 연계됨을 스프링에게 알려준다
public class Memo extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String contents;

    public Memo(String username, String contents){
        this.username = username;
        this.contents = contents;
    }

    public Memo(MemoRequestDto requestDto){
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
    }

    public void update(MemoRequestDto requestDto){
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
    }
}
