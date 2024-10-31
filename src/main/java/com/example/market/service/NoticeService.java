package com.example.market.service;

import com.example.market.model.Notice;
import com.example.market.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeService {

    private final NoticeRepository noticeRepository;

    @Autowired
    public NoticeService(NoticeRepository noticeRepository) {
        this.noticeRepository = noticeRepository;
    }

    public List<Notice> findAll() {
        return noticeRepository.findAll(); // 공지사항 전체 목록 가져오기
    }

    public Notice findById(Long id) {
        return noticeRepository.findById(id).orElse(null); // 특정 공지사항 가져오기
    }

    public void save(Notice notice) {
        noticeRepository.save(notice); // 공지사항 저장
    }

    public void delete(Long id) {
        noticeRepository.deleteById(id); // 공지사항 삭제
    }
}
