package com.example.aabbcc.repo;


import com.example.aabbcc.model.Apply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplyRepo extends JpaRepository<Apply, Long> {

    List<Apply> findByCompanyJobIdAndCvRankNotNullOrderByCvRankDesc(Long id);
}
