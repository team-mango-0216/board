package org.teammango.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.teammango.domain.mango_board;
import org.teammango.dto.BoardDTO;
import org.teammango.repository.BoardRepository;

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


}
