package clofi.runningplanet.crew.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import clofi.runningplanet.crew.dto.request.CreateCrewReqDto;
import clofi.runningplanet.crew.service.CrewService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class CrewController {

	private final CrewService crewService;

	@PostMapping("/api/crew")
	public ResponseEntity<Void> createCrew(@RequestBody @Valid CreateCrewReqDto reqDto) {
		Long crewId = crewService.createCrew(reqDto);
		return ResponseEntity.created(URI.create("/api/crew/" + crewId)).build();
	}
}