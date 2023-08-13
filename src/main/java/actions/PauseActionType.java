package actions;

import io.gatling.javaapi.core.ScenarioBuilder;
import org.openapitools.client.model.Action;
import org.openapitools.client.model.Pause;

public class PauseActionType implements ActionType {
  @Override
  public ScenarioBuilder buildScenario(ScenarioBuilder scenarioBuilder, Action action) {
    Pause pause = (Pause) action;
    return scenarioBuilder.pause(pause.getSeconds());
  }
}
