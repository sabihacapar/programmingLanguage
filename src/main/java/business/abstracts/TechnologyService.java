package business.abstracts;

import java.util.List;

import business.request.CreateTechnologyRequest;
import business.request.UpdateTechnologyRequest;
import business.response.TechnologiesResponse;

public interface TechnologyService {
	List<TechnologiesResponse> getAll();

    void add(CreateTechnologyRequest createTechnologyRequest) throws Exception;
    void delete(int id) throws Exception;
    void update(UpdateTechnologyRequest updateTechnologyRequest,int id) throws Exception;

    TechnologiesResponse getByID(int id);
}
