package business.abstracts;

import java.util.List;

import business.request.CreateLanguageRequest;
import business.request.UpdateLanguageRequest;
import business.response.GetAllLanguagesResponse;

public interface LanguageService {

	List<GetAllLanguagesResponse> getAll();
	GetAllLanguagesResponse getById(int id) throws Exception;
	void add(CreateLanguageRequest createLanguageRequest) throws Exception;
	void deleteById(int id);
	void update(UpdateLanguageRequest updateLanguageRequest) throws Exception;
	
}
