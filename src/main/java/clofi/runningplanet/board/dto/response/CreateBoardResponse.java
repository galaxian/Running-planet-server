package clofi.runningplanet.board.dto.response;

import clofi.runningplanet.board.domain.Board;

public record CreateBoardResponse(Long boardId) {

	public static CreateBoardResponse of(Board board) {
		return new CreateBoardResponse(
			board.getId()
		);
	}
}
