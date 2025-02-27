package com.utk.util;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@JsonSerialize(using = Category.CategorySerializer.class)
@JsonDeserialize(using = Category.CategoryDeserializer.class)
@Getter
@RequiredArgsConstructor
public enum Category {
	PERSONAL("Personal"), FORMAL("Formal"), MISC("MISCELLANEOUS");

	private final String name;

	public static Category eventOf(final String value) {
		Optional<Category> result = Arrays.stream(Category.values()).filter(m -> m.getName().equalsIgnoreCase(value)).findAny();
		return result.orElse(null);
	}

	public static final class CategorySerializer extends JsonSerializer<Category> {

		@Override
		public void serialize(Category value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
			gen.writeString(value.getName());
		}

	}

	public static final class CategoryDeserializer extends JsonDeserializer<Category> {

		@Override
		public Category deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
			final String jsonValue = p.getText();
			return Category.eventOf(jsonValue);
		}

	}

}
