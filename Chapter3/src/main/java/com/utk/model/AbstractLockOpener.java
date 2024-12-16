package com.utk.model;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component("abstractLockOpener")
abstract class AbstractLockOpener implements LockOpener {

	@Override
	@Lookup("keyhelper")
	public abstract KeyHelper getMyKeyOpener();

	@Override
	public void openLock() {
		getMyKeyOpener().open();

	}

}
