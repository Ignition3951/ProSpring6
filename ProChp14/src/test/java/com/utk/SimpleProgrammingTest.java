package com.utk;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.Test;

import com.utk.entity.Singer;

import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;

public class SimpleProgrammingTest {

	List<Singer> singers = List.of(
			new Singer.Builder().fistName("John").lastName("Mayer").birthDate(LocalDate.of(1977, 10, 16)).build(), // 48
			new Singer.Builder().fistName("B.B").lastName("King").birthDate(LocalDate.of(1929, 9, 16)).build(), // 96
			new Singer.Builder().fistName("Peggy").lastName("Lee").birthDate(LocalDate.of(1920, 5, 26)).build(), // 105
			new Singer.Builder().fistName("Ella").lastName("Fitzgerald").birthDate(LocalDate.of(1917, 4, 25)).build());// 108

	Function<Singer, Pair<Singer, Integer>> computeAge = singer -> Pair.of(singer,
			Period.between(singer.getBirthDate(), LocalDate.now()).getYears());
	Predicate<Pair<Singer, Integer>> checkAge = pair -> pair.getRight() > 50;

	@Test
	void imperativePlay() {
		int ageSum = 0;
		for (Singer singer : singers) {
			Pair<Singer, Integer> pair = computeAge.apply(singer);
			if (checkAge.test(pair)) {
				ageSum += pair.getRight();
			}
		}
		assertEquals(306, ageSum);
	}

	@Test
	void streamsPlay() {
		int ageSum = singers.stream().map(computeAge).filter(checkAge).map(Pair::getRight).reduce(Integer::sum)
				.orElseThrow(() -> new RuntimeException("Something went terribly wrong!!!"));
		assertEquals(306, ageSum);
	}

	@Test
	void reactivePlay() {
		Flux.fromIterable(singers).map(computeAge).filter(checkAge).map(Pair::getRight).reduce(0, Integer::sum)
				.subscribe(new BaseSubscriber<>() {
					@Override
					protected void hookOnNext(Integer ageSum) {
						assertEquals(306, ageSum);
					}
				});
	}
}
