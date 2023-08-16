package simulation;

import actions.ActionType;
import actions.ActionTypeFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import io.gatling.javaapi.core.OpenInjectionStep;
import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import loadtest.LoadTestFactory;
import loadtest.LoadTestType;
import org.openapitools.client.model.Action;
import org.openapitools.client.model.GatlingSimulation;
import org.openapitools.client.model.LoadTest;
import org.openapitools.client.model.Scenario;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import static io.gatling.javaapi.core.CoreDsl.scenario;

public class YamlSimulation extends Simulation {

  ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());

  GatlingSimulation gatlingSimulation;

  {
    try {
      String path = System.getenv("LOAD_TEST_YAML_CONFIG");
      if (path == null) {
        path = "src/main/resources/gatling.yaml";
      }
      File f = new File(path);
      System.out.println("value of path is " + path);
      gatlingSimulation = objectMapper.readValue(f, GatlingSimulation.class);
      for (Scenario scenario : gatlingSimulation.getScenarios()) {
        ScenarioBuilder scenarioBuilder = scenario(scenario.getTitle());
        for (Action action : scenario.getActions()) {
          ActionType actionType = ActionTypeFactory.getActionType(action);
          scenarioBuilder = actionType.buildScenario(scenarioBuilder, action);
        }
        List<OpenInjectionStep> openInjectionSteps = new LinkedList<>();
        for (LoadTest loadTest : scenario.getLoadTests()) {
          LoadTestType loadTestType = LoadTestFactory.getLoadTestType(loadTest);
          openInjectionSteps.add(loadTestType.getOpenInjectionStep(loadTest));
        }

        for (OpenInjectionStep openInjectionStep : openInjectionSteps) {
          scenarioBuilder.injectOpen(openInjectionStep);
        }
        {
          setUp(scenarioBuilder.injectOpen(openInjectionSteps.toArray(OpenInjectionStep[]::new)));
        }
      }

    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

}
