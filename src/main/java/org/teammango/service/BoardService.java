package org.teammango.service;

import org.teammango.dto.BoardDTO;

public interface BoardService {

    BoardDTO readOne(int post_id);

    void modify(BoardDTO boardDTO);

    void remove(int post_id);

}
