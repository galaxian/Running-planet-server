package clofi.runningplanet.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import clofi.runningplanet.board.domain.Board;
import clofi.runningplanet.board.domain.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
	List<Comment> findAllByBoard(Board board);
}
