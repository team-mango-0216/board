package org.teammango.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.teammango.domain.mango_board;

public interface BoardRepository extends JpaRepository<mango_board, Integer> {
}
