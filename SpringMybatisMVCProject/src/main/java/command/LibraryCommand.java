package command;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LibraryCommand {
	private Integer boardNum;
	private String boardName;
	private String boardPass;
	private String boardSubject;
	private String boardContent;
	// 파일들을 배열로 받기 위해서 MultipartFile로 사용
	private MultipartFile [] report;
}
