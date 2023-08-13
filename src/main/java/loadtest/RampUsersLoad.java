package loadtest;

import io.gatling.javaapi.core.OpenInjectionStep;
import org.openapitools.client.model.LoadTest;
import org.openapitools.client.model.RampUsers;

import static io.gatling.javaapi.core.CoreDsl.rampUsers;

public class RampUsersLoad implements LoadTestType {
  @Override
  public OpenInjectionStep getOpenInjectionStep(LoadTest loadTest) {
    RampUsers rampUsers = (RampUsers) loadTest;
    return rampUsers(rampUsers.getUsers()).during(rampUsers.getDurationInSeconds());
  }
}
