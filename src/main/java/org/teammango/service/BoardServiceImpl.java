package org.teammango.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.teammango.domain.mango_board;
import org.teammango.dto.BoardDTO;
import org.teammango.dto.BoardListAllDTO;
import org.teammango.dto.PageRequestDTO;
import org.teammango.dto.PageResponseDTO;
import org.teammango.repository.BoardRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class BoardServiceImpl implements BoardService {

    private final ModelMapper modelMapper;
    private final BoardRepository boardRepository;

    @Override
    public Integer register(BoardDTO boardDTO) {

        // boardDTO를 받아 dtoToEntity로 처리하고 post_id 리턴
        mango_board mango_board = dtoToEntity(boardDTO);
        int post_id = boardRepository.save(mango_board).getPost_id();

        return post_id;
    }

    @Override
    public PageResponseDTO<BoardDTO> list(PageRequestDTO pageRequestDTO) {
        return null;
    }

    @Override
    public PageResponseDTO<BoardListAllDTO> listWithAll(PageRequestDTO pageRequestDTO) {
        return null;
    }

//    @Override
//    public PageResponseDTO<BoardListAllDTO> listWithAll(PageRequestDTO pageRequestDTO) {
//        String[] types = pageRequestDTO.getTypes();
//        String keyword = pageRequestDTO.getKeyword();
//        Pageable pageable = pageRequestDTO.getPageable("post_id");
//
//        Page<BoardListAllDTO> result = boardRepository.searchWithAll(types, keyword, pageable);
//
//
//        return PageResponseDTO.<BoardListAllDTO>withAll()
//                .pageRequestDTO(pageRequestDTO)
//                .dtoList(result.getContent())
//                .total((int)result.getTotalElements())
//                .build();
//    }


}
