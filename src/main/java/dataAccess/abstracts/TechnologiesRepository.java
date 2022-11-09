package dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Technology;

public interface TechnologiesRepository extends JpaRepository<Technology, Integer>{

}
