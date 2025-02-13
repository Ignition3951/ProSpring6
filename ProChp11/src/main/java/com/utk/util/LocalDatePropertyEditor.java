package com.utk.util;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDatePropertyEditor extends PropertyEditorSupport {

	private DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(LocalDate.parse(text, dateFormat));
	}
}
