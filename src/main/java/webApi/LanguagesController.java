package webApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import business.abstracts.LanguageService;
import business.request.CreateLanguageRequest;
import business.request.UpdateLanguageRequest;
import business.response.GetAllLanguagesResponse;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {
	
	private LanguageService languageService;
	
	@Autowired
	public LanguagesController(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@GetMapping("/getAll")
	public List<GetAllLanguagesResponse> getAll() {
		return languageService.getAll();
	}
	
	@GetMapping("/getById/{id}")
	public GetAllLanguagesResponse getById(int id) throws Exception {
		return languageService.getById(id);
	}
	
	@PostMapping("/add")
	public void add(CreateLanguageRequest language) throws Exception {
		languageService.add(language);
	}
	
	@PutMapping("/update/{id}")
	public void update(UpdateLanguageRequest updateLanguageRequest, int id) throws Exception {
		languageService.update(updateLanguageRequest);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(int id) {
		languageService.deleteById(id);
	}
	
}