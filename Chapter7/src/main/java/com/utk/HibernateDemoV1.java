package com.utk;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.utk.config.HibernateConfig;
import com.utk.dao.SingerDao;
import com.utk.entity.Album;

public class HibernateDemoV1 {

	private static final Logger logger = LoggerFactory.getLogger(HibernateDemoV1.class);

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);
		SingerDao singerDao = context.getBean(SingerDao.class);

//		logger.info("-----Listing singers with findAll");
//		singerDao.findAll().forEach(s -> logger.info(s.toString()));
		logger.info("-----Listing singers with findAllWithAlbum");
		singerDao.findAllWithAlbum().forEach(s -> logger.info(s.toString()));
		logger.info("----Listing findById using named Query : {}", singerDao.findById(1l));
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
//		singerDao.save(singer);
		var singerUpdate = singerDao.findById(4l);
		Album updateAlbum = singerUpdate.getAlbums().stream().filter(a -> a.getTitle().equals("My Kind of Blues"))
				.findFirst().orElse(null);
		logger.info("----Album fetched : {}", updateAlbum.toString());
		singerUpdate.setFistName("BBUPdate");
		singerUpdate.setLastName("KingUPdate");
		singerUpdate.removeALbum(updateAlbum);
		// int beforeUpdateversion = singerUpdate.getVersion();
		// logger.info("VERSION BEFORE THE UPDATE IS : {}", beforeUpdateversion);
		singerDao.save(singerUpdate);
		int afterUpdateversion = singerUpdate.getVersion();
		logger.info("VERSION AFTER THE UPDATE IS : {}", afterUpdateversion);
		context.close();

	}

}
