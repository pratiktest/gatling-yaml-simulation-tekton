package loadtest;

import io.gatling.javaapi.core.OpenInjectionStep;
import org.openapitools.client.model.ConstantUsersPerSec;
import org.openapitools.client.model.LoadTest;

import static io.gatling.javaapi.core.CoreDsl.constantUsersPerSec;

public class ConstantUsersPerSecLoad implements LoadTestType {
  @Override
  public OpenInjectionStep getOpenInjectionStep(LoadTest loadTest) {
    ConstantUsersPerSec constantUsersPerSec = (ConstantUsersPerSec) loadTest;
    return constantUsersPerSec(constantUsersPerSec.getUsersPerSec()).
        during(constantUsersPerSec.getDurationInSeconds());
  }
}
