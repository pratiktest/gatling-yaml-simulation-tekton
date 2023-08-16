import com.fasterxml.jackson.databind.ObjectMapper;
import io.gatling.app.Gatling;
import io.gatling.core.config.GatlingPropertiesBuilder;
import org.apache.commons.io.FileUtils;
import simulation.YamlSimulation;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class Engine {

  public static void main(String[] args) {

    deleteGatlingFolderIfExists();
    GatlingPropertiesBuilder props = new GatlingPropertiesBuilder()
        .resourcesDirectory("")
        .simulationClass(YamlSimulation.class.getName())
        .resultsDirectory("gatling")
        .binariesDirectory("classes");
    Gatling.fromMap(props.build());
    writeResults();

  }

  private static void deleteGatlingFolderIfExists() {
    String gatlingFolderPAth = getGatlingFolderPath();
    try {
      FileUtils.deleteDirectory(new File(gatlingFolderPAth));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private static String getGatlingFilesPath() {
    String gatlingFilesPath = System.getenv("GATLING_FILES_PATH");
    if (gatlingFilesPath == null) {
      gatlingFilesPath = System.getProperty("user.dir");
    }
    return gatlingFilesPath;
  }

  private static String getGatlingFolderPath() {
    return getGatlingFilesPath() + "/gatling";
  }

  private static String getGatlingDirectoryNameContainingTimestamp() {
    String gatlingFolderPath = getGatlingFolderPath();
    File gatlingFolder = new File(gatlingFolderPath);
    File[] listOfFiles = gatlingFolder.listFiles();
    String directoryName = null;

    if (listOfFiles != null && listOfFiles.length == 1) {
      directoryName = listOfFiles[0].getName();
    }
    return directoryName;
  }

  private static void writeResults() {
    String gatlingFilesPath = getGatlingFilesPath();
    String directoryName = getGatlingDirectoryNameContainingTimestamp();
    if (directoryName != null) {
      File stats = new File(gatlingFilesPath + "/gatling/" + directoryName + "/js/stats.json");
      ObjectMapper objectMapper = new ObjectMapper();
      try {
        Map m = objectMapper.readValue(stats, Map.class);
        Map statsMap = (Map) m.get("stats");
        String json = objectMapper.writeValueAsString(statsMap);
        String gatlingResultPath = System.getenv("GATLING_RESULT_PATH");
        System.out.println("value of result path is " + gatlingResultPath);
        if (gatlingResultPath != null) {
          File f = new File(gatlingResultPath);
          FileUtils.writeStringToFile(f, json, StandardCharsets.UTF_8);
        }

      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
  }

}