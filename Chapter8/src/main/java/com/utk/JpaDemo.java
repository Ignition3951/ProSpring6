package com.utk;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.utk.config.JpaConfig;
import com.utk.entity.Singer;
import com.utk.service.SingerService;

public class JpaDemo {

	private static Logger logger = LoggerFactory.getLogger(JpaDemo.class);

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JpaConfig.class);
		SingerService singerService = context.getBean(SingerService.class);
		List<Singer> singers = singerService.findAll().toList();
		logger.info("SIZE OF SINGER IS : {}", singers.size());
//		var singer = new Singer();
//		singer.setFistName("BB");
//		singer.setLastName("King");
//		singer.setBirthDate(LocalDate.of(1940, 8, 16));
//		var album = new Album();
//		album.setTitle("My Kind of Blues");
//		album.setReleaseDate(LocalDate.of(1961, 7, 18));
//		singer.addAlbum(album);
//		album = new Album();
//		album.setTitle("A Heart Full of Blues");
//		album.setReleaseDate(LocalDate.of(1962, 3, 20));
//		singer.addAlbum(album);
//		singerService.save(singer);
//		Optional<Singer> singer = singerService.findById(9l);
//		Album album = singer.get().getAlbums().stream().filter(s -> "My Kind of Blues".equals(s.getTitle())).findAny()
//				.orElse(null);
//		singer.get().setFistName("Eunice Kathleen");
//		singer.get().setLastName("Waymon");
//		singer.get().removeALbum(album);
//		singerService.save(singer.get());
		Optional<Singer> singer = singerService.findById(9l);
		singerService.delete(singer.get());
		context.close();

	}

}
