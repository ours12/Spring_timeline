package com.example.timeline.service;

import com.example.timeline.domain.Memo;
import com.example.timeline.domain.MemoRepository;
import com.example.timeline.domain.MemoRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MemoService {

    private final MemoRepository memoRepository;

    @Transactional
    public Long update(Long id, MemoRequestDto requestDto){
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 아이디가 없습니다.")
        );
        memo.update(requestDto);
        return memo.getId();
    }
}
