package classes;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import entities.Abn;

import repo.AbnRepo;



import java.util.Date;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Configuration
public class LoadData {

	
		  Date mydate =new Date();
	
	
	  
	  
	  private static final Logger log = LoggerFactory.getLogger(LoadData.class);

	  
	  sub mysub = sub.gold;
	  @Bean
	  CommandLineRunner initDatabase(AbnRepo repository) {

	    return args -> {
	      log.info("Preloading " + repository.save(new Abn(1,mydate ,mydate ,31,10095,mysub,null)));
	     
	    };
	  }
}
