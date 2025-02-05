package com.utk.model;

import com.utk.service.impl.GrammyGuitarist;

public class Documentarist {

	private GrammyGuitarist grammyGuitarist;

	public void execute() {
		grammyGuitarist.sing();
		grammyGuitarist.talk();
	}

	public void setDep(GrammyGuitarist grammyGuitarist) {
		this.grammyGuitarist = grammyGuitarist;
	}
}
