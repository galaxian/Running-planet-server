package clofi.runningplanet.board.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import clofi.runningplanet.board.dto.response.CreateBoardResponse;
import clofi.runningplanet.board.dto.request.CreateBoardRequest;
import clofi.runningplanet.board.factory.BoardFactory;
import clofi.runningplanet.board.repository.BoardImageRepository;
import clofi.runningplanet.board.repository.BoardRepository;
import clofi.runningplanet.crew.domain.Crew;
import clofi.runningplanet.crew.repository.CrewRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional
@Service
public class BoardQueryService {

	private final BoardFactory boardFactory;
	private final CrewRepository crewRepository;
	private final S3StorageManagerUseCase storageManagerUseCase;
	public CreateBoardResponse create(Long crewId, CreateBoardRequest createBoardRequest, List<MultipartFile> imageFile) {

		//TODO: 멤버
		Crew crew = crewRepository.findById(crewId).orElseThrow(
			() -> new IllegalArgumentException("크루가 존재하지 않습니다"));

		List<String> imageUrlList = Optional.ofNullable(imageFile)
			.filter(image -> !image.isEmpty())
			.map(storageManagerUseCase::uploadImages)
			.orElseGet(ArrayList::new);

		return boardFactory.insert(crew, createBoardRequest, imageUrlList);
	}
}