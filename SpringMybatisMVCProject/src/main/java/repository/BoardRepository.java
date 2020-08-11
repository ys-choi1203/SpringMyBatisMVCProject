package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.BoardDTO;

@Repository
public class BoardRepository {
	@Autowired
	private SqlSession sqlSession;
	
	private final String namespace="mappers.boardMapper";
	private String statement;
	
	public void insertBoard(BoardDTO dto) {
		statement = namespace + ".insertBoard";
		sqlSession.insert(statement, dto);
	}

	public List<BoardDTO> getBoardList(BoardDTO boardDTO) {
		statement = namespace + ".getBoardList";
		return sqlSession.selectList(statement, boardDTO);
	}

	public int getBoardCount() {
		statement = namespace + ".getBoardCount";
		return sqlSession.selectOne(statement);
	}

	public void boardUpdate(BoardDTO board) {
		statement = namespace + ".boardUpdate";
		sqlSession.update(statement, board);
	}

	public void boardDelete(BoardDTO board) {
		statement = namespace + ".boardDelete";
		sqlSession.delete(statement, board);
	}

}
