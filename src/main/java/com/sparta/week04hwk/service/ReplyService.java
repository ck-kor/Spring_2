package com.sparta.week04hwk.service;


import com.sparta.week04hwk.dto.ReplyDeleteDto;
import com.sparta.week04hwk.dto.ReplyRequestDto;
import com.sparta.week04hwk.dto.ReplyUpdateDto;
import com.sparta.week04hwk.model.Reply;
import com.sparta.week04hwk.model.Timestamped;
import com.sparta.week04hwk.repository.ReplyRepository;
import com.sparta.week04hwk.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReplyService extends Timestamped {

    private final ReplyRepository replyRepository;

    // 댓글 저장
    @Transactional
    public Reply save(Long id, ReplyRequestDto requestDto, UserDetailsImpl userDetails) {
        String memberName = userDetails.getMember().getUsername(); // 댓글에 이름 + 작성자가 맞나 확인할때 쓰기
        Reply reply = new Reply(id, requestDto, memberName);

        return replyRepository.save(reply);
    }
    // 댓글 조회
    public List<Reply> read(Long id) {
        return replyRepository.findByContentsNoOrderByModifiedAtDesc(id);
    }
    // 댓글 수정
    @Transactional
    public Reply update(Long id, ReplyUpdateDto requestDto, UserDetailsImpl userDetails) {
        Long commentId = requestDto.getId(); // 댓글 id를 가져온다.
        Reply list = replyRepository.findByContentsNoAndId(id, commentId);
        String updateName = list.getName();
        String updateReply = requestDto.getReply();
        if ( updateName.equals(userDetails.getUsername())) // 로그인한 username이랑 댓글의 작성자 name이랑 비교
            list.update(updateReply); // 기존 댓글을 새로운 댓글로 변경
        return list;
    }
    // 댓글 삭제
    @Transactional
    public void delete(Long id, ReplyDeleteDto requestDto, UserDetailsImpl userDetails) {
        Long commentId =requestDto.getId(); // AJAX로 보내준 id값을 저장. [ 삭제버튼 누른 댓글의 id ]
        Reply list = replyRepository.findByContentsNoAndId(id, commentId); // 해당 게시글에 있는 댓글을 가져온다.
//        Reply reply =replyRepository.findById(idx).orElseThrow(
//                () -> new NullPointerException("해당 아이디가 없습니다.")
//        );
        String deleteName = list.getName();
        if ( deleteName.equals(userDetails.getUsername()))
            replyRepository.deleteById(commentId);
    }


}
