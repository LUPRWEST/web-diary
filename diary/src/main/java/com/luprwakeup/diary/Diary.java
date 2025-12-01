package com.luprwakeup.diary;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity 
public class Diary {

    @Id //고유 번호(PK)입니다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동으로 
    private Long id;

    private String title;   // 일기 제목
    private String content; // 일기 내용

    // --- 아래는 게터/세터(Getter/Setter) ---

    public Long getId() {
        return id;
    }
    // id는 자동 생성되므로 setId는 굳이 안 만듭니다.

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}