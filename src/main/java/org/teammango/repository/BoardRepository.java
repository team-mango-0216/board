package org.teammango.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.teammango.domain.mango_board;
import org.teammango.dto.BoardListAllDTO;

public interface BoardRepository extends JpaRepository<mango_board, Integer> {


}
