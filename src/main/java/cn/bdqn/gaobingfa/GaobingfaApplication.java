package cn.bdqn.gaobingfa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class GaobingfaApplication {

	public static void main(String[] args) {
		SpringApplication.run(GaobingfaApplication.class, args);
	}
}
