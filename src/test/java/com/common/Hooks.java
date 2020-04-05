package com.common;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends Driver {

	Util util = new Util();

	@Before
	public void driverInvoke() {

		Driver.driverSetup();

	}

	@After
	public void postExecActions(Scenario scenario) {
		util.takeScreenShot(scenario);
		Driver.quitDriver();
	}

}
