package model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LibraryBoardDTO {
	Integer boardNum;
	String userId;
	String boardName;
	String boardPass;
	String boardSubject;
	String boardContent;
	Timestamp boardDate;
	String ipAddr;
	Integer readCount;
	String originalFileName;
	String storeFileSize;
	String fileSize;
	// 한 쿼리문으로 모든 행 또는 한 행만 가져오기 위해서
	StartEndPageDTO startEndPageDTO;
	
	public LibraryBoardDTO(
			Integer boardNum, String userId, String boardName, String boardPass,
			String boardSubject,String boardContent, Timestamp boardDate,
			String ipAddr, Integer readCount,
			String originalFileName, String storeFileSize, String fileSize) {

		this.boardNum = boardNum;
		this.userId = userId;
		this.boardName = boardName;
		this.boardPass = boardPass;
		this.boardSubject = boardSubject;
		this.boardContent = boardContent;
		this.boardDate = boardDate;
		this.ipAddr = ipAddr;
		this.readCount = readCount;
		this.originalFileName = originalFileName;
		this.storeFileSize = storeFileSize;
		this.fileSize = fileSize;
		this.startEndPageDTO = startEndPageDTO;
	}
	
}
