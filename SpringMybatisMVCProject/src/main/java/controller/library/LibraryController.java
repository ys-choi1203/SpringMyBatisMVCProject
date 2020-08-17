package controller.library;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import command.LibraryCommand;
import service.libraryBoard.LibraryBoardListService;
import service.libraryBoard.LibraryBoardService;
import validator.LibraryCommandValidator;

@Controller
@RequestMapping("lib")
public class LibraryController {
	@Autowired
	LibraryBoardService libraryBoardService;
	@Autowired
	LibraryBoardListService libraryBoardListService; 
	@RequestMapping("libBoard")
	public String libBoard(
			@RequestParam(value="page", required = false) 
								Integer page, Model model) {
		
		libraryBoardListService.libraryBoardList(page, model);
		return "lib_Board/lib_board_list";
	}
	
	@RequestMapping("boardWriteForm")
	public String boardWriteForm() {
		return "lib_Board/lib_board_write";
	}
	
	@RequestMapping("boardWritePro")
	public String boardWritePro(LibraryCommand libraryCommand,
								Errors errors, HttpServletRequest request) {
		new LibraryCommandValidator().validate(libraryCommand, errors);
		
		if(errors.hasErrors()) {
			return "lib_Board/lib_board_write"; 
		}
		
		libraryBoardService.writePro(libraryCommand, request);
		return "redirect:/lib/libBoard";
	}
}
