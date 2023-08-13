package httpmethods;

import io.gatling.javaapi.core.ScenarioBuilder;
import org.openapitools.client.model.Execute;

public interface HttpMethodType {

  ScenarioBuilder buildMethod(ScenarioBuilder scenarioBuilder, Execute execute);
}
