package org.teammango;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.teammango.domain.mango_board;
import org.teammango.repository.BoardRepository;

import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
class TeamMangoApplicationTests {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void testInsert() {
        IntStream.rangeClosed(1,100).forEach(i -> {
            mango_board mango_board = org.teammango.domain.mango_board.builder()
                    .title("title..." + i)
                    .content("content..." + i)
                    .build();

            mango_board result = boardRepository.save(mango_board);
            log.info("post_id: " + result.getPost_id());
        });
    }

}
