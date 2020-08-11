package controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import command.BoardCommand;
import service.board.BoardDetailServie;
import service.board.BoardListService;
import service.board.BoardWriteService;
import validator.BoardCommandValidator;

@Controller
@RequestMapping("qna")
public class BoardController {
	@Autowired
	BoardWriteService boardWriteService;
	@Autowired
	BoardListService boardListService;
	@Autowired
	BoardDetailServie boardDetailService;
	
	@RequestMapping(value = "qnaList", method = RequestMethod.GET)
	public String list(@RequestParam(value="page",defaultValue = "1")
						Integer page, Model model) {
		boardListService.boardAllSelect(page, model);
		return "board/qna_board_list";
	}
	
	@RequestMapping(value = "boardWrite")
	public String boardWrite(BoardCommand boardCommand) {
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
			return "redirect:/qna/qnaList";
		}	
	}
	
	@RequestMapping(value="boardDetail")
	public String boardDetail(@RequestParam("num") Integer boardNum,
								Model model) {
		boardDetailService.boardDetail(boardNum, model);
		return "board/qna_board_view";		
	}
	
	@RequestMapping(value="qnaModify")
	public String qnaModify(BoardCommand boardCommand,
			@RequestParam("num") Integer boardNum, Model model) {
		boardDetailService.boardDetail(boardNum, model);
		return "board/qna_board_modify";
	}
	
	@RequestMapping(value="qnaBoardModifyPro")
	public String qnaBoardModifyPro(BoardCommand boardCommand, Errors errors) {
		new BoardCommandValidator().validate(boardCommand, errors);
		if(errors.hasErrors()) {
			return "board/qna_board_modify";
		}
		String path = boardDetailService.boardUpdate(boardCommand, errors);
		
		return path;
	}
	
	@RequestMapping(value="qnaDelete")
	public String qnaDelete(BoardCommand boardCommand, Errors errors) {
		new BoardCommandValidator().validate(boardCommand, errors);
		if(errors.hasErrors()) {
			return "board/qna_board_modify";
		}
		
		String path = boardDetailService.boardDelete(boardCommand, errors);
				
		return path;
		
	}
	

}
