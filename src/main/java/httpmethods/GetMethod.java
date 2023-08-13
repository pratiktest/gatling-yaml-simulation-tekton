package httpmethods;

import io.gatling.javaapi.core.ScenarioBuilder;
import org.openapitools.client.model.Execute;
import org.openapitools.client.model.Http;
import org.openapitools.client.model.KeyValue;

import java.util.HashMap;
import java.util.Map;

import static io.gatling.javaapi.http.HttpDsl.http;

public class GetMethod implements HttpMethodType {

  @Override
  public ScenarioBuilder buildMethod(ScenarioBuilder scenarioBuilder, Execute execute) {
    Http getHttpRequest = execute.getHttp();
    if (getHttpRequest != null) {
      Map<String, String> headerMap = new HashMap<>();
      if (getHttpRequest.getHeaders() != null && !getHttpRequest.getHeaders().isEmpty()) {
        for (KeyValue keyValue : getHttpRequest.getHeaders()) {
          headerMap.put(keyValue.getKey(), keyValue.getValue());
        }
      }
      return scenarioBuilder.exec(http(getHttpRequest.getTitle())
          .get(getHttpRequest.getEndpoint()).headers(headerMap));
    }
    return null;
  }
}
