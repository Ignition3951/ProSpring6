package com.utk.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.utk.service.impl.GrammyGuitarist;

@Component("documentarist")
public class NewDocumentarist {

	private GrammyGuitarist grammyGuitarist;

	public void execute() {
		grammyGuitarist.sing();
		Guitar guitar = new Guitar();
		guitar.setBrand("Gibson");
		grammyGuitarist.sing(guitar);
		grammyGuitarist.talk();
	}

	@Autowired
	@Qualifier("johnMayer")
	public void setGrammyGuitarist(GrammyGuitarist grammyGuitarist) {
		this.grammyGuitarist = grammyGuitarist;
	}

}
