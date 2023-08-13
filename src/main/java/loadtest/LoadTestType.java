package loadtest;

import io.gatling.javaapi.core.OpenInjectionStep;
import org.openapitools.client.model.LoadTest;

public interface LoadTestType {

  OpenInjectionStep getOpenInjectionStep(LoadTest loadTest);
}
