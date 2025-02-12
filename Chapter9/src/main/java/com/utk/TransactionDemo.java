package com.utk;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import com.utk.config.JpaConfig;
import com.utk.entity.Album;
import com.utk.entity.Singer;
import com.utk.service.SingerService;

@SpringBootApplication
public class TransactionDemo {

	private static final Logger logger = LoggerFactory.getLogger(TransactionDemo.class);

	public static void main(String[] args) {
		SpringApplication.run(TransactionDemo.class, args);
	}

	@Bean
	public ApplicationRunner applicationRunner() {
		return env -> {
			AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JpaConfig.class);
			SingerService singerService = context.getBean(SingerService.class);
			List<Singer> singers = singerService.findAll().toList();
			List<Singer> singersWithAlbums = singerService.findAllWithAlbum().toList();
			logger.info("SIZE OF SINGER IS : {}", singers.size());
//			Optional<Singer> singeroptional = singerService.findById(11l);
//			singerService.delete(singeroptional.get());
			var singer = new Singer();
			singer.setFistName("BB");
			singer.setLastName("King");
			singer.setBirthDate(LocalDate.of(1940, 8, 16));
			var album = new Album();
			album.setTitle("My Kind of Blues");
			album.setReleaseDate(LocalDate.of(1961, 7, 18));
			singer.addAlbum(album);
			album = new Album();
			album.setTitle("A Heart Full of Blues");
			album.setReleaseDate(LocalDate.of(1962, 3, 20));
			singer.addAlbum(album);
			singerService.saveSingerWithAlbums(singer);
			context.close();
		};
	}

}
