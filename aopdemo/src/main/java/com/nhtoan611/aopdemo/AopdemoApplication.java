package com.nhtoan611.aopdemo;

import com.nhtoan611.aopdemo.dao.AccountDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(AccountDAO accountDAO) {
		return runner -> {
//			demoTheBeforeAdvice(accountDAO);
//			demoTheAfterReturningAdvice(accountDAO);
			demoException(accountDAO);
		};
	}

	private void demoException(AccountDAO accountDAO) {
		accountDAO.getAccountById();
	}

	private void demoTheAfterReturningAdvice(AccountDAO accountDAO) {
		List<Integer> accountIds = accountDAO.getAccountId();
		System.out.println("===>>> Execution result: ");
		accountIds.forEach(System.out::println);
	}

	private void demoTheBeforeAdvice(AccountDAO accountDAO) {
		accountDAO.addAccount();
		System.out.println("Let's call it again");
		accountDAO.addAccount();
	}
}
