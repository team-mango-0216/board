package org.teammango.service;


import org.teammango.domain.mango_board;
import org.teammango.dto.BoardDTO;
import org.teammango.dto.BoardListAllDTO;
import org.teammango.dto.PageRequestDTO;
import org.teammango.dto.PageResponseDTO;

public interface BoardService {

    PageResponseDTO<BoardDTO> list(PageRequestDTO pageRequestDTO);

    //댓글의 숫자까지 처리


    //게시글의 이미지와 댓글의 숫자까지 처리
    PageResponseDTO<BoardListAllDTO> listWithAll(PageRequestDTO pageRequestDTO);

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
