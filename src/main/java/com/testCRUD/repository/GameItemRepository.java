package com.testCRUD.repository;

import com.testCRUD.model.GameItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameItemRepository extends JpaRepository<GameItem, Long> {

}
