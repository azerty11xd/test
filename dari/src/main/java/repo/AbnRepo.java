package repo;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Abn;

public interface AbnRepo extends JpaRepository<Abn, Long> {

}
