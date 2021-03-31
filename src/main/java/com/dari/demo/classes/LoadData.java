package com.dari.demo.classes;

import com.dari.demo.entities.Abn;
import com.dari.demo.entities.User;
import com.dari.demo.repo.AbnRepo;
import com.dari.demo.repo.UserRepo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class LoadData {
	
	
	

	
    Date mydate = new Date();
    

    private static final Logger log = LoggerFactory.getLogger(LoadData.class);

    sub mysub = sub.gold;
    
    Gender gender = Gender.M;
    Profession pro = Profession.BusinessOwner;
    
    
    
  
    //1,"test",22,gender
   
    @Bean
    CommandLineRunner initDatabase(AbnRepo repository ,UserRepo urepo) {
        return args -> {
        	/*
        	user.setAbn(null);user.setAds(null);user.setId((long) 1);user.setGender(gender);
        	user.setAge(22);user.setName("test");user.setProfession(pro);*/
             
        	User user = new User ((long)1,"test",22,gender,null,pro);
        	Abn abn = new Abn(1, mydate, mydate, 31, 10095, mysub );
        	abn.setUser(user);
        	user.setAbn(abn);

        	  log.info("Preloading " + urepo.save(user));

        };
    }
}
