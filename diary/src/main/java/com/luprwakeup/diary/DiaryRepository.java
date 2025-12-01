package com.luprwakeup.diary;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DiaryRepository extends JpaRepository<Diary, Long> {
    // 비어있어도 됩니다. JpaRepository를 상속받는 순간
    // 저장(save), 조회(findAll), 삭제(delete) 등의 기능이 자동 생성됩니다.
}