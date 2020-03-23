package com.common;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends Driver {

	@Before
	public void driverInvoke() {

		Driver.driverSetup();

	}

	@After
	public void driverClose() {

		Driver.quitDriver();

	}

}
