package com.sparta.week3_hwk.service;

import com.sparta.week3_hwk.domain.Memo;
import com.sparta.week3_hwk.domain.MemoRepository;
import com.sparta.week3_hwk.domain.MemoRequestDto;
import com.sparta.week3_hwk.domain.MemoResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemoService {

    private final MemoRepository memoRepository;

    @Transactional
    public boolean update(Long id, MemoRequestDto requestDto) {
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        if( memo.getPassword().equals( requestDto.getPassword() ) ){
            memo.update(requestDto);
            return true;
        } else {
            return false;
        }
    }

    @Transactional
    public boolean delete(Long id, MemoRequestDto requestDto) {
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        if( memo.getPassword().equals( requestDto.getPassword() ) ){
            memoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
    public MemoResponseDto detail(Long id){
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        MemoResponseDto responseDto = new MemoResponseDto();
        responseDto.setCreatedAt(memo.getCreatedAt());
        responseDto.setModifiedAt(memo.getModifiedAt());
        responseDto.setContents(memo.getContents());
        responseDto.setUsername(memo.getUsername());
        return responseDto;
    }



}