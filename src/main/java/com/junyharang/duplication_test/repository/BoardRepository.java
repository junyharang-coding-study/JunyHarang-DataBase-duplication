package com.junyharang.duplication_test.repository;

import com.junyharang.duplication_test.model.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {}
