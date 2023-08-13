package actions;

import io.gatling.javaapi.core.ScenarioBuilder;
import org.openapitools.client.model.Action;

public interface ActionType {

  ScenarioBuilder buildScenario(ScenarioBuilder scenarioBuilder, Action action);
}
