package com.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.board.model.FreeBoard;

@Repository
public interface FreeBoardRepository extends JpaRepository<FreeBoard, Long>{
	
}
