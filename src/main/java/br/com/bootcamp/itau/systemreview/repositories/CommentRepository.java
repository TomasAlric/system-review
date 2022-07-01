package br.com.bootcamp.itau.systemreview.repositories;

import br.com.bootcamp.itau.systemreview.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
