package com.sparta.week3_hwk.service;

import com.sparta.week3_hwk.domain.Memo;
import com.sparta.week3_hwk.domain.MemoRepository;
import com.sparta.week3_hwk.domain.MemoRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemoService {

    private final MemoRepository memoRepository;

    @Transactional
    public Long update(Long id, MemoRequestDto requestDto) {
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        memo.update(requestDto);
        return memo.getId();
    }

    public Memo getdetail(Long id) {
        Optional<Memo> result = memoRepository.findById(id);
        return result.get();
    }
}