package SearchSpecification;

import java.util.Collection;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Predicate;

import org.hibernate.query.criteria.internal.predicate.ComparisonPredicate.ComparisonOperator;
import org.springframework.data.jpa.domain.Specification;

import com.dari.demo.classes.SearchCriteria;
import com.dari.demo.entities.Abn;


public class AbnSpecification implements Specification<Abn> {
	
	  private SearchCriteria criteria;

	    public AbnSpecification(SearchCriteria criteria) {
		super();
		this.criteria = criteria;
	}
	    public AbnSpecification() {
		super();
		
	}
	    
	    
	
	    
	    
	    

		@Override
	    public Predicate toPredicate
	      (Root<Abn> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
	 
			
	        if (criteria.getOperation().equalsIgnoreCase(">")) {
	            return builder.greaterThanOrEqualTo(
	              root.<String> get(criteria.getKey()), criteria.getValue().toString());
	        } 
	        else if (criteria.getOperation().equalsIgnoreCase("<")) {
	            return builder.lessThanOrEqualTo(
	              root.<String> get(criteria.getKey()), criteria.getValue().toString());
	        } 
	        else if (criteria.getOperation().equalsIgnoreCase(":")) {
	            if (root.get(criteria.getKey()).getJavaType() == String.class) {
	                return builder.like(
	                  root.<String>get(criteria.getKey()), "%" + criteria.getValue() + "%");
	            } else {
	                return builder.equal(root.get(criteria.getKey()), criteria.getValue());
	            }
	        }
	        return null;
	    }
		 
		
		
	
}
