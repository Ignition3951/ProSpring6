package com.utk.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("standardLockOpener")
public class StandardLockOpener implements LockOpener {

	private KeyHelper keyHelper;

	@Autowired
	@Qualifier("keyhelper")
	public void setKeyHelper(KeyHelper keyHelper) {
		this.keyHelper = keyHelper;
	}

	@Override
	public KeyHelper getMyKeyOpener() {
		return keyHelper;
	}

	@Override
	public void openLock() {
		keyHelper.open();

	}

}
