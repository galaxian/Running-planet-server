package clofi.runningplanet.crew.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import clofi.runningplanet.crew.domain.CrewApplication;

@Repository
public interface CrewApplicationRepository extends JpaRepository<CrewApplication, Long> {
	Optional<CrewApplication> findByCrewIdAndMemberId(Long crewId, Long id);
}
