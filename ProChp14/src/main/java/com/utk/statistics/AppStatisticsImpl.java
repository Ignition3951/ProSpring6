package com.utk.statistics;

import java.util.List;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;
import org.springframework.jmx.export.annotation.ManagedOperationParameters;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

import com.utk.entity.Singer;
import com.utk.service.SingerService;

@Component
@ManagedResource(description = "JMX managed resource", objectName = "jmxDemo:name=ProSingerAppCh18")
public class AppStatisticsImpl implements AppStatistics {

	private final SingerService singerService;

	public AppStatisticsImpl(SingerService singerService) {
		this.singerService = singerService;
	}

	@ManagedAttribute(description = "Number of singers in the application")
	@Override
	public int getTotalSingerCount() {
		return singerService.findAll().size();
	}

	@ManagedOperation
	@Override
	public String findJohn() {
		List<Singer> singers = singerService.findByFistNameAndLastName("John", "Mayer");
		if (!singers.isEmpty()) {
			return singers.get(0).getFistName() + " " + singers.get(0).getLastName() + " "
					+ singers.get(0).getBirthDate();
		}
		return "Not Found";
	}

	@ManagedOperation(description = "Find singer by first name and last name")
	@ManagedOperationParameters({
			@ManagedOperationParameter(name = "firstName",description = "Singer firstName"),
			@ManagedOperationParameter(name = "lastName",description = "Singer lastName")
	})
	@Override
	public String findSinger(String firstName, String lastName) {
		List<Singer> singers = singerService.findByFistNameAndLastName(firstName, lastName);
		if (!singers.isEmpty()) {
			return singers.get(0).getFistName() + " " + singers.get(0).getLastName() + " "
					+ singers.get(0).getBirthDate();
		}
		return "Not Found";
	}

}
