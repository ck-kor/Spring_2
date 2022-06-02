package com.sparta.week04hwk.repository;

import com.sparta.week04hwk.model.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
//    List<Reply> findAllByOrderBymodifiedAtDesc();
    List<Reply> findByContentsNoOrderByModifiedAtDesc(Long contentsNo);
    Reply findByContentsNoAndId(Long contentsNo, Long id);

}
