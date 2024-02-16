package org.teammango.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.teammango.domain.mango_board;
import org.teammango.dto.BoardDTO;
import org.teammango.repository.BoardRepository;

import java.util.Optional;


@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class BoardServiceImpl implements BoardService{

    private final ModelMapper modelMapper;

    private final BoardRepository boardRepository;

    @Override
    public BoardDTO readOne(int post_id) {

        Optional<mango_board> result = boardRepository.findById(post_id);

        mango_board mango_board = result.orElseThrow();

        BoardDTO boardDTO = modelMapper.map(mango_board, BoardDTO.class);

        return boardDTO;

    }

    @Override
    public void modify(BoardDTO boardDTO) {

        Optional<mango_board> result = boardRepository.findById(boardDTO.getPost_id());

        mango_board mango_board = result.orElseThrow();

        mango_board.change(boardDTO.getTitle(), boardDTO.getContent());

        boardRepository.save(mango_board);

    }

    @Override
    public void remove(int post_id) {

        boardRepository.deleteById(post_id);

    }
}
