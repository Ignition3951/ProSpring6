package com.utk.statistics;

import org.hibernate.SessionFactory;
import org.hibernate.stat.EntityStatistics;
import org.hibernate.stat.Statistics;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
@ManagedResource(description = "JMX Managed hibernate resource", objectName = "jmxDemo:name=ProSpring6App-Hibernate")
public class CustomHibernateStatistics {

	private final SessionFactory sessionFactory;

	public CustomHibernateStatistics(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Statistics statistics;

	@PostConstruct
	public void init() {
		statistics = sessionFactory.getStatistics();
	}

	@ManagedOperation(description = "Get statistics for entity name")
	@ManagedOperationParameter(name = "entityName", description = "Full class name for the entity")
	public EntityStatistics getEntityStatistics(String entityName) {
		return statistics.getEntityStatistics(entityName);
	}

	@ManagedAttribute
	public long getEntityDeleteCount() {
		return statistics.getEntityDeleteCount();
	}

	@ManagedAttribute
	public long getEntityInsertCount() {
		return statistics.getEntityInsertCount();
	}

	@ManagedAttribute
	public String[] getEntityNames() {
		return statistics.getEntityNames();
	}

	@ManagedAttribute
	public String[] getQueries() {
		return statistics.getQueries();
	}

	@ManagedAttribute
	public long getTransactionCount() {
		return statistics.getTransactionCount();
	}

	@ManagedAttribute
	public long getPrepareStatementCount() {
		return statistics.getPrepareStatementCount();
	}

}
