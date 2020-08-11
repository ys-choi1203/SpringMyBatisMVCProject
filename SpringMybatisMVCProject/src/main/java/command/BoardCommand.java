package command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardCommand {
	private String userId;
	private String boardName;
	private String boardPass;
	private String boardSubject;
	private String boardContent;
	private Integer boardNum;
}
