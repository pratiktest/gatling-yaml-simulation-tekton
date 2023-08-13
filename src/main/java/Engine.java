import com.fasterxml.jackson.databind.ObjectMapper;
import io.gatling.app.Gatling;
import io.gatling.core.config.GatlingConfiguration;
import io.gatling.core.config.GatlingPropertiesBuilder;
import org.apache.commons.io.FileUtils;
import scala.collection.mutable.HashMap;
import simulation.YamlSimulation;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Properties;

public class Engine {

//  static Class<? extends Simulation> createClass(String fullName )
//          throws NotFoundException, CannotCompileException
//  {
//    ClassPool pool = ClassPool.getDefault();
//
//    // Create the class.
//    CtClass subClass = pool.makeClass( fullName );
//    final CtClass superClass = pool.get( Simulation.class.getName() );
//    subClass.setSuperclass( superClass );
//    subClass.setModifiers( Modifier.PUBLIC );
//
//    // Add a constructor which will call super( ... );
//    CtClass[] params = new CtClass[]{
//            pool.get( MigratorDefinition.class.getName() ),
//            pool.get( GlobalConfiguration.class.getName())
//    };
//    final CtConstructor ctor = CtNewConstructor.make( params, null, CtNewConstructor.PASS_PARAMS, null, null, subClass );
//    subClass.addConstructor( ctor );
//
//    return subClass.toClass();
//  }

  public static void main(String[] args) {

    GatlingPropertiesBuilder props = new GatlingPropertiesBuilder()
        .resourcesDirectory("")
        .simulationClass(YamlSimulation.class.getName())
        .resultsDirectory("gatling")
        .binariesDirectory("classes");
    Properties systemProperties = System.getProperties();
    GatlingConfiguration.load(new HashMap<>());
    Gatling.fromMap(props.build());

    String userdir = System.getProperty("user.dir");
    System.out.println("userdir is " + userdir);
    File folder = new File(userdir + "/gatling");
    File[] listOfFiles = folder.listFiles();
    String directoryName = null;

    if (listOfFiles != null && listOfFiles.length == 1) {
      directoryName = listOfFiles[0].getName();
    }

    if (directoryName != null) {
      File stats = new File(userdir + "/gatling/" + directoryName + "/js/stats.json");
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
