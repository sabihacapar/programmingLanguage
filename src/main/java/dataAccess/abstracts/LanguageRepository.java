package dataAccess.abstracts;
import org.springframework.data.jpa.repository.JpaRepository;

import entities.Language;


public interface LanguageRepository extends JpaRepository<Language,Integer>{

}
