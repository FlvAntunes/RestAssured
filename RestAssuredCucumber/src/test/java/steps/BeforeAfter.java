package steps;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class BeforeAfter {

	private static Scenario scenario;

	public static Scenario getScenario() {
		return scenario;
	}

	@Before
	public void before(Scenario scenario) {
		BeforeAfter.scenario = scenario;

	}
	
}
