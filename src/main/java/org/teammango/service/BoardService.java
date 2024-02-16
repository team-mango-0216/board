package org.teammango.service;


import org.teammango.domain.mango_board;
import org.teammango.dto.BoardDTO;

public interface BoardService {

    Integer register(BoardDTO boardDTO);

    default mango_board dtoToEntity(BoardDTO boardDTO) {

        mango_board mango_board = org.teammango.domain.mango_board.builder()
                .post_id(boardDTO.getPost_id())
                .title(boardDTO.getTitle())
                .content(boardDTO.getContent())
                .build();

        return mango_board;
    }


}
