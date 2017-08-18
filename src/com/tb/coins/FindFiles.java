package com.tb.coins;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FindFiles {
  public static void main(final String[] args) {
    final List<File> results = find(new File("."), "pom.xml");
    results.forEach(System.out::println);
  }

  public static List<File> find(final File root, final String filename) {
    if (root == null || filename == null) {
      throw new RuntimeException("Invalid input");
    }

    final List<File> result = new ArrayList<>();

    // if root is a file, check if its name is given filename, if yes add to result.
    if (root.isFile()) {
      if (filename.equals(root.getName())) {
        result.add(root);
      }
    } else if (root.isDirectory()) {
      for (final File currentFile : root.listFiles()) {
        // recursively search for each file inside this directory.
        result.addAll(find(currentFile, filename));
      }
    } else {
      throw new RuntimeException("Invalid input file: " + root);
    }

    return result;
  }
}
