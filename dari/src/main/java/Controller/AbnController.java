package Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import classes.AbnNotFoundException;
import entities.Abn;
import repo.AbnRepo;


@RestController
public class AbnController {

	
	 private final AbnRepo repository;
	 
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
}
