package com.luprwakeup.diary;

import java.util.List; // 리스트(목록)를 다루기 위한 도구

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; // 데이터를 화면으로 나르는 택배 상자
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    private DiaryRepository diaryRepository;

    @GetMapping("/")
    public String home(Model model) {
        // 1. 창고지기에게 "모든 일기 다 가져와"라고 시킵니다.
        List<Diary> diaryList = diaryRepository.findAll();

        // 2. 가져온 일기 뭉치를 "diaryList"라는 이름표를 붙여 택배 상자(model)에 담습니다.
        model.addAttribute("diaryList", diaryList);

        return "main"; // 3. 상자를 든 채로 main.html로 갑니다.
    }

    @GetMapping("/write")
    public String writePage() {
        return "write";
    }

    @PostMapping("/write")
    public String saveDiary(@RequestParam String title, @RequestParam String content) {
        Diary diary = new Diary();
        diary.setTitle(title);
        diary.setContent(content);
        diaryRepository.save(diary);
        return "redirect:/";
    }
}