package org.teammango;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.teammango.domain.mango_board;
import org.teammango.repository.BoardRepository;

import java.util.Optional;
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

    @Test
    public void testUpdate() {

        int post_id = 100;

        Optional<mango_board> result = boardRepository.findById(post_id);

        mango_board mango_board = result.orElseThrow();

        mango_board.change("update title...100", "update content...100");

        boardRepository.save(mango_board);
    }

    @Test
    public void testDelete() {

        int post_id = 1;

        boardRepository.deleteById(post_id);
    }

//    @Test
//    public void testPaging(){
//
//        Pageable pageable = PageRequest.of(0,10, Sort.by("post_id").descending());
//
//        Page<mango_board> result = boardRepository.findAll(pageable);
//    }

}