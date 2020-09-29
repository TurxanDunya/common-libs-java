package com.gamingbaku;

import com.gamingbaku.dao.impl.UserRepository;
import com.gamingbaku.dao.inter.UserDaoInter;
import com.gamingbaku.entity.User;
import com.gamingbaku.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableCaching
public class GamingBakuDbAppJpaSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(GamingBakuDbAppJpaSpringApplication.class, args);
	}


	@Autowired
	private UserRepository userRepository;

	@Bean
	public CommandLineRunner run(){
		CommandLineRunner clr = new CommandLineRunner(){

			@Override
			public void run(String... args) throws Exception {
				List<User> list = userRepository.findAll();

				System.out.println(list);
			}
		};
		return clr;
	}

}
