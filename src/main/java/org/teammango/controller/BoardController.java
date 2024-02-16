package org.teammango.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.teammango.dto.BoardDTO;
import org.teammango.service.BoardService;

@Controller
@Log4j2
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/register")
    public void registerGET() {
        log.info("GET register......");
    }

    @PostMapping("/register")
    public String registerPOST(BoardDTO boardDTO, RedirectAttributes redirectAttributes) {

        log.info("POST register.....");

        log.info(boardDTO);

        int post_id = boardService.register(boardDTO);

        redirectAttributes.addFlashAttribute(post_id);

        return "redirect:/board/list";
    }


}
