package com.elearning;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.elearning.models.User;
import com.elearning.services.UserService;

@SpringBootApplication
@EnableJpaAuditing
public class ELearningSystemApplication {
	
	private static final Logger log = LoggerFactory.getLogger(ELearningSystemApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ELearningSystemApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(UserService srv) {
	    return (args) -> {
	    	if(srv.countUsers()==0) {
	    		User user=new User();
	    		user.setUserid("admin@gmail.com");
	    		user.setPwd("admin123");
	    		user.setRole("Admin");
	    		user.setAddress("Noida");
	    		user.setActive(true);
	    		user.setPhone("9811763737");
	    		user.setDob("1999-10-10");
	    		user.setCpwd("admin123");
	    		user.setName("Administrator");
	    		srv.addUser(user);
	    		log.info("Admin user created successfully");
	    	}else {
	    		log.info("Admin user already created");
	    	}
	    };
	}
}
