package com.dari.demo.Controller;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.dari.demo.classes.AbnNotFoundException;
import com.dari.demo.entities.Abn;
import com.dari.demo.repo.AbnRepo;


import SearchSpecification.AbnSpecificationsBuilder;
import SearchSpecification.CustomRsql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import cz.jirutka.rsql.parser.ast.AndNode;
import cz.jirutka.rsql.parser.RSQLParser;
import cz.jirutka.rsql.parser.ast.Node;

@RestController
public class AbnController {


	 private final AbnRepo repository;
	 
	 
	 /*
	
	 */
	 
	 
	 AbnController(AbnRepo repository) {
		this.repository = repository;
     }
	 
	 
	 
	 @GetMapping("/abn")@ResponseBody
	  List<Abn> all() {
	    return repository.findAll();
	  }
	 
	 @PostMapping("/abn")@ResponseBody
	  Abn newabn (@RequestBody Abn newabn) {
	    return repository.save(newabn);
	  }

	 @GetMapping("/abn/{id}")@ResponseBody
	 Abn one(@PathVariable Long id) {
	    
	    return repository.findById(id)
	      .orElseThrow(() -> new AbnNotFoundException(id));
	  }
	 
	 @PutMapping(path="/abn",consumes={"application/json"})@ResponseBody
	  void replaceAbn(@RequestBody Abn newAbn) {
	    repository.save(newAbn);
	    
	  }
	 
	 @DeleteMapping("/employees/{id}")
	  void deleteAbn(@PathVariable Long id) {
	    repository.deleteById(id);
	  }
	 
	    @GetMapping("/iabn")
	    @ResponseBody
	    public List<Abn> search(@RequestParam(value = "search") String search) {
	        AbnSpecificationsBuilder builder = new AbnSpecificationsBuilder();
	        Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
	        Matcher matcher = pattern.matcher(search + ",");
	        while (matcher.find()) {
	            builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
	        }
	        
	        Specification<Abn> spec = builder.build();
	        return repository.findAll(spec);
	    }
	    
	    @GetMapping("/iiabn")
	    @ResponseBody
	    public List<Abn> findAllByRsql(@RequestParam(value = "search") String search) {
	        Node rootNode = new RSQLParser().parse(search);
	        Specification<Abn> spec = rootNode.accept(new CustomRsql<Abn>());
	        return repository.findAll(spec);
	    }
	 
}
