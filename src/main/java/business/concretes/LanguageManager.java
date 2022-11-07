package business.concretes;

import java.util.ArrayList;
import java.util.List;

import business.abstracts.LanguageService;
import business.request.CreateLanguageRequest;
import business.request.UpdateLanguageRequest;
import business.response.GetAllLanguagesResponse;
import dataAccess.abstracts.LanguageRepository;
import entities.Language;

public class LanguageManager implements LanguageService{
	private LanguageRepository languageRepository;
	
	public LanguageManager(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}

	@Override
	public List<GetAllLanguagesResponse> getAll() {
		
		List<Language> languages = languageRepository.findAll();
		

		List<GetAllLanguagesResponse> languagesResponses = new ArrayList<GetAllLanguagesResponse>();
		
		for(Language language : languages) {
			GetAllLanguagesResponse responseI = new GetAllLanguagesResponse();
			responseI.setId(language.getId());
			responseI.setName(language.getName());
			languagesResponses.add(responseI);
		}
		return languagesResponses;
	}

	@Override
	public GetAllLanguagesResponse getById(int id) throws Exception {

		List<Language> languages = languageRepository.findAll();
		GetAllLanguagesResponse responseI=null;
		
		for(Language language : languages) {
			if(language.getId()==id) {
				 responseI = new GetAllLanguagesResponse();
				responseI.setId(language.getId());
				responseI.setName(language.getName());
			}
			
		}
		if(responseI ==null) throw new Exception("Id bulunamadı:"+id);
		

		return responseI;
	}

	@Override
	public void add(CreateLanguageRequest createLanguageRequest) throws Exception {
		Language language = new Language();
		language.setName(createLanguageRequest.getName());
		
		this.languageRepository.save(language);
		
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(UpdateLanguageRequest updateLanguageRequest) throws Exception {
		// TODO Auto-generated method stub
		
	}

	

//	@Override
//	public void update(UpdateLanguageRequest updateLanguageRequest) throws Exception {
//
//
//		
//		Language language=languageRepository.getReferenceById(id);
//		language.setName(updateLanguageRequest.getName());
//		languageRepository.save(language);
//	}
//
//	@Override
//	public void deleteById(int id) {
//		boolean exist = languageRepository.existsById(id);
//		if(exist) languageRepository.delete(id);
//		
//	}
	

}
