package com.example.market.controller;

import com.example.market.model.Notice;
import com.example.market.service.NoticeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/menu_announcement")
public class NoticeController {

    private final NoticeService noticeService;

    public NoticeController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    // 공지사항 목록 페이지
    @GetMapping
    public String noticeList(Model model) {
        List<Notice> notices = noticeService.findAll(); // 공지사항 목록 가져오기
        model.addAttribute("notices", notices); // 모델에 목록 추가
        return "noticeList";  // 공지사항 목록 페이지
    }


    // 공지사항 상세 보기 페이지
    @GetMapping("/view")
    public String noticeDetail(@RequestParam("id") Long id, Model model) {
        Notice notice = noticeService.findById(id);
        model.addAttribute("notice", notice);
        return "noticeDetail";
    }

    // 공지사항 작성 페이지
    @GetMapping("/write")
    public String writeForm() {
        return "noticeWrite";
    }

    // 공지사항 저장
    @PostMapping("/save")
    public String saveNotice(@ModelAttribute Notice notice) {
        noticeService.save(notice);
        return "redirect:/menu_announcement";
    }

    // 공지사항 삭제
    @PostMapping("/delete")
    public String deleteNotice(@RequestParam("id") Long id) {
        noticeService.delete(id);
        return "redirect:/menu_announcement";
    }

}
