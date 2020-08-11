package repository;

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

}
