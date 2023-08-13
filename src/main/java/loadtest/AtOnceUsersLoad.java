package loadtest;

import io.gatling.javaapi.core.OpenInjectionStep;
import org.openapitools.client.model.AtOnceUsers;
import org.openapitools.client.model.LoadTest;

import static io.gatling.javaapi.core.CoreDsl.atOnceUsers;

public class AtOnceUsersLoad implements LoadTestType {

  @Override
  public OpenInjectionStep getOpenInjectionStep(LoadTest loadTest) {
    AtOnceUsers atOnceUsers = (AtOnceUsers) loadTest;
    return atOnceUsers(atOnceUsers.getUsers());
  }
}
