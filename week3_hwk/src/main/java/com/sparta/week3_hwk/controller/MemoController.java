package com.sparta.week3_hwk.controller;

import com.sparta.week3_hwk.domain.Memo;
import com.sparta.week3_hwk.domain.MemoRepository;
import com.sparta.week3_hwk.domain.MemoRequestDto;
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

    @PutMapping("/api/memos/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto){

        memoService.update(id, requestDto);
        return id;
    }

    @GetMapping("/api/memos")
    public List<Memo> readMemo(){
        return memoRepository.findAllByOrderByModifiedAtDesc();
    }

    @DeleteMapping("/api/memos/{id}")
    public Long deleteMemo(@PathVariable Long id , @RequestBody MemoRequestDto requestDto){
        if( requestDto.getPassword().equals() )
        memoRepository.deleteById(id);
        return id;
    }

//    @DeleteMapping("/api/memos/{id}")
//    public Long deleteMemo(@PathVariable Long id){
//        memoRepository.deleteById(id);
//        return id;
//    }


}