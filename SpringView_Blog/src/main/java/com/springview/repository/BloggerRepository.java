package com.springview.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.springview.domain.Blogger;
import org.springframework.stereotype.Repository;

@Repository
public interface BloggerRepository extends CrudRepository<Blogger, Long> {
	List<Blogger> findAll();
}
