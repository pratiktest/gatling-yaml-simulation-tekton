package httpmethods;

import org.openapitools.client.model.Http;

public class HttpMethodFactory {

  public static HttpMethodType getHttpMethodType(Http http) {
    if (http.getMethod().equals(Http.MethodEnum.GET)) {
      return new GetMethod();
    }
    return null;
  }
}
