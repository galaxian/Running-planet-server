package clofi.runningplanet.running.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import clofi.runningplanet.running.domain.Coordinate;
import clofi.runningplanet.running.domain.Record;

public interface CoordinateRepository extends JpaRepository<Coordinate, Long> {

  Optional<Coordinate> findByRecord(Record record);

}