package org.teammango.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.teammango.dto.BoardDTO;
import org.teammango.dto.BoardListAllDTO;
import org.teammango.dto.PageRequestDTO;
import org.teammango.dto.PageResponseDTO;
import org.teammango.service.BoardService;

@RestController
@Log4j2
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

//    @GetMapping("/list")
//    public void list(Model model) {
//
//        log.info("list,,,,");
//
//        model.addAttribute("list", "list");
//
//    }
@GetMapping("/list")
public void list(PageRequestDTO pageRequestDTO, Model model){

    //PageResponseDTO<BoardDTO> responseDTO = boardService.list(pageRequestDTO);

    PageResponseDTO<BoardDTO> responseDTO =
            boardService.list(pageRequestDTO);

    log.info(responseDTO);

    model.addAttribute("responseDTO", responseDTO);
}


}
