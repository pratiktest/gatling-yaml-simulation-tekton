import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.util.Objects.requireNonNull;

public class IDEPathHelper {

  static final Path mavenSourcesDirectory;

  static final Path mavenResourcesDirectory;

  static final Path mavenBinariesDirectory;

  static final Path resultsDirectory;

  static final Path recorderConfigFile;

  static {
    try {
      System.out.println("here");
      Path projectRootDir = Paths.get(requireNonNull(IDEPathHelper.class.getClassLoader().getResource("gatling.conf"),
          "Couldn't locate gatling.conf").toURI()).getParent().getParent().getParent();
      Path mavenTargetDirectory = projectRootDir.resolve("target");
      Path mavenSrcTestDirectory = projectRootDir.resolve("src").resolve("main");

      mavenSourcesDirectory = mavenSrcTestDirectory.resolve("java");
      mavenResourcesDirectory = mavenSrcTestDirectory.resolve("resources");
      mavenBinariesDirectory = mavenTargetDirectory.resolve("classes");
      resultsDirectory = mavenTargetDirectory.resolve("gatling");
      recorderConfigFile = mavenResourcesDirectory.resolve("recorder.conf");
    } catch (URISyntaxException e) {
      throw new ExceptionInInitializerError(e);
    }
  }
}
