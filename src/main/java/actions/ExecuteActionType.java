package actions;

import httpmethods.HttpMethodFactory;
import httpmethods.HttpMethodType;
import io.gatling.javaapi.core.ScenarioBuilder;
import org.openapitools.client.model.Action;
import org.openapitools.client.model.Execute;

public class ExecuteActionType implements ActionType {
  @Override
  public ScenarioBuilder buildScenario(ScenarioBuilder scenarioBuilder, Action action) {
    Execute execute = (Execute) action;
    //right now http is the only use case, we can create an interface later once we add more execute use cases
    if (execute.getHttp() != null) {
      HttpMethodType httpMethodType = HttpMethodFactory.getHttpMethodType(execute.getHttp());
      return httpMethodType.buildMethod(scenarioBuilder, execute);
    }
    return null;
  }
}
