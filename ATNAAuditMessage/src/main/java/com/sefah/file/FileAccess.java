package com.sefah.file;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author fahrenholz
 *
 *         (c) 2018 - Alle Rechte vorbehalten
 *
 */
public class FileAccess {

  private FileAccess() {
    // SQ
  }

  public static byte[] getBytesOfPackageMessage(final String packagepath)
      throws IOException, URISyntaxException {
    return getBytesOfMessage(packagepath, true);
  }

  public static byte[] getBytesOfMessage(final String absolutePath)
      throws IOException, URISyntaxException {
    return getBytesOfMessage(absolutePath, false);
  }

  private static byte[] getBytesOfMessage(final String packagepath, final boolean b)
      throws IOException, URISyntaxException {
    if (b) {
      return Files.readAllBytes(Paths.get(FileAccess.class.getResource(packagepath).toURI()));
    }

    return Files.readAllBytes(Paths.get(packagepath));
  }
}
