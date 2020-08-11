package controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import command.BoardCommand;
import service.board.BoardWriteService;
import validator.BoardCommandValidator;

@Controller
@RequestMapping("qna")
public class BoardController {
	@Autowired
	BoardWriteService boardWriteService;
	
	@RequestMapping(value = "qnaList", method = RequestMethod.GET)
	public String list(Model model) {
		return "board/qna_board_list";
	}
	
	@RequestMapping(value = "boardWrite")
	public String boardWrite() {
		return "board/qna_board_write";
	}
	
	@RequestMapping(value = "qnaWritePro", method = RequestMethod.POST)
	public String qnaWritePro(BoardCommand boardCommand, Errors errors,
								HttpSession session, HttpServletRequest request) {
		new BoardCommandValidator().validate(boardCommand, errors);
		if(errors.hasErrors()) {
			return "board/qna_board_write";
		}else {
			boardWriteService.boardInsert(boardCommand, session, request);
			return "redirect:/qna/qna_board_list";
		}
	}
	
}
