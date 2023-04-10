package multi.second.project.domain.message.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import multi.second.project.domain.message.domain.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long>, MessageRepositoryExtension {
    Page<Message> findMessageListByNoteNtIdx(Long ntIdx, Pageable pageable);
    Page<Message> findByMemberUserId(String userId, Pageable pageable);

    Page<Message> findAllByNoteNtIdx(Long ntIdx, Pageable pageable);
//	List<Gallery> findCommentByPostIdx(Long postIdx);

}

