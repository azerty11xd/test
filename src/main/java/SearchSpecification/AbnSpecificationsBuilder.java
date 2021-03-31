package SearchSpecification;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.jpa.domain.Specification;

import com.dari.demo.classes.SearchCriteria;
import com.dari.demo.entities.Abn;

public class AbnSpecificationsBuilder {

	
	  private final List<SearchCriteria> params;

	    public AbnSpecificationsBuilder() {
	        params = new ArrayList<SearchCriteria>();
	    }

	    public AbnSpecificationsBuilder with(String key, String operation, Object value) {
	        params.add(new SearchCriteria(key, operation, value));
	        return this;
	    }

	    public Specification<Abn> build() {
	        if (params.size() == 0) {
	            return null;
	        }
	        

	        List<Specification<Abn>> specs = new ArrayList<Specification<Abn>>();
	        for (SearchCriteria param : params) {
	            specs.add(new AbnSpecification(param));
	        }

	        Specification<Abn> result = specs.get(0);
	        for (int i = 1; i < specs.size(); i++) {
	            result = Specification.where(result).and(specs.get(i));
	        }
	        return result;
	      
	    }
}
