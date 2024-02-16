package org.teammango.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.teammango.dto.BoardDTO;
import org.teammango.dto.PageRequestDTO;
import org.teammango.service.BoardService;

@RestController
@RequestMapping("/board")
@Log4j2
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping({"/read","/modify"})
    public void read(int post_id, PageRequestDTO pageRequestDTO, Model model) {

        BoardDTO boardDTO = boardService.readOne(post_id);

        log.info(boardDTO);

        model.addAttribute("dto", boardDTO);
    }

    @PostMapping("/modify")
    public String modify(PageRequestDTO pageRequestDTO,BoardDTO boardDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){

        log.info("board modify post..." + boardDTO);

        if (bindingResult.hasErrors()) {
            log.info("has errors.....");
//            String link = pageRequestDTO.getLink();
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            redirectAttributes.addAttribute("post_id", boardDTO.getPost_id());

            return "redirect:/board/modify?";//+link 뒤에 붙여야 함.
        }

        boardService.modify(boardDTO);

        redirectAttributes.addFlashAttribute("result", "modified");
        redirectAttributes.addAttribute("post_id", boardDTO.getPost_id());

        return "redirect:/board/read";
    }

    @PostMapping("/remove")
    public String remove(int post_id, RedirectAttributes redirectAttributes) {

        log.info("remove post.." + post_id);

        boardService.remove(post_id);

        redirectAttributes.addFlashAttribute("result", "removed");

        return "redirect:/board/list";
    }

}
