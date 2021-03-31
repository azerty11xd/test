package com.dari.demo.repo;

import com.dari.demo.entities.Abn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AbnRepo extends JpaRepository<Abn, Long>,JpaSpecificationExecutor<Abn>  {

}
