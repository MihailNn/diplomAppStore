package iba.group.diplomAppStore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//аннотация состоящая из 3-х других аннотаций:
//1.@SpringBootConfiguration обозначает этот класс как класс конфигурации
//2.@EnableAutoConfiguration включает автоматическое конфигурирование Spring Boot. Эта аннотацияи говорит Spring Boot автоматически настроить любые компоненты, которые вам понадобятся
//3.@ComponentScan включает сканирование компонентов
@SpringBootApplication
public class DiplomAppStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiplomAppStoreApplication.class, args);
	}

}
