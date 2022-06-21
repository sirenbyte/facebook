package com.example.akf.repository;

import com.example.akf.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> getBySenderUserIdAndReceivedUserId(Long userId,Long friendId);
}
