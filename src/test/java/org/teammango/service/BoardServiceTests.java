package org.teammango.service;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.teammango.dto.BoardDTO;

@SpringBootTest
@Log4j2
public class BoardServiceTests {

    @Autowired
    private BoardService boardService;

    @Test
    public void testModify() {

        BoardDTO boardDTO = BoardDTO.builder()
                .post_id(100)
                .title("updated...100")
                .content("updated content...100")
                .build();

        boardService.modify(boardDTO);

    }

    @Test
    public void testRemove() {

        boardService.remove(100);

    }
}
