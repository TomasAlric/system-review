package br.com.bootcamp.itau.systemreview.repositories;

import br.com.bootcamp.itau.systemreview.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
}
