package business.concretes;

import java.util.ArrayList;
import java.util.List;

import business.abstracts.LanguageService;
import business.abstracts.TechnologyService;
import business.request.CreateTechnologyRequest;
import business.request.UpdateTechnologyRequest;
import business.response.GetAllLanguagesResponse;
import business.response.TechnologiesResponse;
import dataAccess.abstracts.TechnologiesRepository;
import entities.Language;
import entities.Technology;

public class TechnologyManager implements TechnologyService{

	private TechnologiesRepository technologyRepository;
    private LanguageService languageService;
    
    
    private boolean isThereID(int id) {
        List<Technology> technologies = technologyRepository.findAll();
        for (Technology technology : technologies) {
            if (technology.getTechnologyId() == id) {
                return true;
            }
        }
        return false;
    }
	@Override
	public List<TechnologiesResponse> getAll() {
		 List<Technology> technologies = technologyRepository.findAll();
	        List<TechnologiesResponse> technologiesResponses = new ArrayList<>();
	        for (Technology technology : technologies) {
	            TechnologiesResponse responseI = new TechnologiesResponse();
	            responseI.setName(technology.getTechnologyName());
	            responseI.setId(technology.getTechnologyId());
	            responseI.setLanguageID(technology.getLanguage().getId());
	            responseI.setLanguageName(technology.getLanguage().getName());
	            technologiesResponses.add(responseI);
	        }
	        return technologiesResponses;
	}

	@Override
	public void add(CreateTechnologyRequest createTechnologyRequest) throws Exception {
		Technology technology = new Technology();
        technology.setTechnologyName(createTechnologyRequest.getName());
        technology.setLanguage(languageService.getLanguageById(createTechnologyRequest.getLanguageID()));
        this.technologyRepository.save(technology);
	}

	 @Override
	    public void delete(int id) throws Exception {
	        if (!isThereID(id)) {
	            throw new Exception("ID can not found");
	        }
	        technologyRepository.deleteById(id);
	    }

	 @Override
	    public void update(UpdateTechnologyRequest createTechnologyRequest, int id) throws Exception {
	        if(!isThereID(id)){
	            throw new Exception("Can not find the ID");
	        }
	        GetAllLanguagesResponse language1 = languageService.getById(createTechnologyRequest.getId());
	            Language language = new Language();
	            language.setId(language1.getId());
	            language.setName(language1.getName());
	        for (Technology technology : technologyRepository.findAll()) {
	            if (technology.getTechnologyId() == id) {
	                technology.setTechnologyName(createTechnologyRequest.getName());
	                    technology.setLanguage(languageService.getLanguageById(createTechnologyRequest.getId()));

	                technologyRepository.save(technology);
	                break;
	            }
	        }

	    }
	    @Override
	    public TechnologiesResponse getByID(int id) {
	        Technology technology = technologyRepository.findById(id).get();
	        TechnologiesResponse response = new TechnologiesResponse();
	        response.setName(technology.getTechnologyName());
	        response.setId(technology.getTechnologyId());
	        response.setLanguageName(technology.getLanguage().getName());
	        response.setLanguageID(technology.getLanguage().getId());
	        return response;
	    }


}
