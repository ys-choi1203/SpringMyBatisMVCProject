package service.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import command.BoardCommand;
import model.AuthInfo;
import model.BoardDTO;
import repository.BoardRepository;

public class BoardWriteService {
	@Autowired
	BoardRepository boardRepository;
	
	public void boardInsert(BoardCommand boardCommand, HttpSession session,
							HttpServletRequest request) {
		BoardDTO dto = new BoardDTO();
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		// session에 저장된 userId를 가져옴
		dto.setUserId(authInfo.getUserId());
		dto.setBoardName(boardCommand.getBoardName());
		dto.setBoardPass(boardCommand.getBoardPass());
		dto.setBoardSubject(boardCommand.getBoardSubject());
		dto.setBoardContent(boardCommand.getBoardContent());
		dto.setIpAddr(request.getRemoteAddr());
		
		boardRepository.insertBoard(dto);
	}
	
}
