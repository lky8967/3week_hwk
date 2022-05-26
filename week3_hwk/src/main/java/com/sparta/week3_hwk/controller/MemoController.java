package com.sparta.week3_hwk.controller;

import com.sparta.week3_hwk.domain.Memo;
import com.sparta.week3_hwk.domain.MemoRepository;
import com.sparta.week3_hwk.domain.MemoRequestDto;
import com.sparta.week3_hwk.domain.MemoResponseDto;
import com.sparta.week3_hwk.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class MemoController {

    private final MemoRepository memoRepository;
    private final MemoService memoService;

    @PostMapping("/api/memos")
    public Memo createMemo(@RequestBody MemoRequestDto requestDto) {
        Memo memo = new Memo(requestDto);
        return memoRepository.save(memo);
    }

    @GetMapping("/api/memos")
    public List<Memo> readMemo(){
        return memoRepository.findAllByOrderByModifiedAtDesc();
    }

    @GetMapping("/api/memos/{id}")
    public MemoResponseDto detailMemo(@PathVariable Long id){
        return memoService.detail(id);
    }

    @DeleteMapping("/api/memos/{id}")
    public boolean deleteMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
        return memoService.delete(id, requestDto);
    }

    @PutMapping("/api/memos/{id}")
    public boolean updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
        return memoService.update(id, requestDto);
    }
//    @GetMapping("/api/memos/{id}")
//    public Memo detailMemo(@PathVariable Long id){
//        return memoRepository.findById(id).orElseThrow(
//                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
//        );
//    }
//
//
//    @PutMapping("/api/memos/{id}")
//    public boolean updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto){
//        Memo memo = memoRepository.findById(id).orElseThrow(
//                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
//        );
//        if( memo.getPassword().equals(requestDto.getPassword())){
//            memoService.update(id, requestDto);
//            return true;
//        }
//        return false;
//    }

//    @DeleteMapping("/api/memos/{id}")
//    public boolean deleteMemo(@PathVariable Long id , @RequestBody MemoRequestDto requestDto){
//        Memo memo = memoRepository.findById(id).orElseThrow(
//                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
//        );
//        if( memo.getPassword().equals(requestDto.getPassword()) ){
//            memoRepository.deleteById(id);
//            return true;
//        } else {
//            return false;
//        }
//    }



}