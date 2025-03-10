package org.codenova.talkhub.model.vo;

import lombok.*;

import java.util.Date;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostLike {
    private int id;
    private String userId;
    private int postId;
    private Date createdAt;

}

/*
    lombok library :  자바 코드에서 보일러플레이트(반복 코드)를 자동 생성해주는 라이브러리야!
    Getter, Setter 자동 생성하고, 생성자, toString, Equals 간편화 해주는 라이브러리!
 */