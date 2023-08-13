package loadtest;

import org.openapitools.client.model.LoadTest;

public class LoadTestFactory {

  public static LoadTestType getLoadTestType(LoadTest loadTest) {
    if (loadTest.getLoadTestType().equals(LoadTest.LoadTestTypeEnum.CONSTANTUSERSPERSEC)) {
      return new ConstantUsersPerSecLoad();
    } else if (loadTest.getLoadTestType().equals(LoadTest.LoadTestTypeEnum.RAMPUSERS)) {
      return new RampUsersLoad();
    } else if (loadTest.getLoadTestType().equals(LoadTest.LoadTestTypeEnum.ATONCEUSERS)) {
      return new AtOnceUsersLoad();
    }
    return null;
  }
}
