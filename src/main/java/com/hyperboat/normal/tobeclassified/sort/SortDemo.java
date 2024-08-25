package com.hyperboat.normal.tobeclassified.sort;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author hyperboat
 * @date 2022年03月25日 15:58
 */
public class SortDemo {

  public static void main(String[] args) {
    List<File> files = new ArrayList<>();
    files.add(new File("C:\\Users\\hyperboat\\Documents\\sort\\1.txt"));
    files.add(new File("C:\\Users\\hyperboat\\Documents\\sort\\2.txt"));
    files.add(new File("C:\\Users\\hyperboat\\Documents\\sort\\3.txt"));
    files.add(new File("C:\\Users\\hyperboat\\Documents\\sort\\4.txt"));
    files.add(new File("C:\\Users\\hyperboat\\Documents\\sort\\5.txt"));
    files.add(new File("C:\\Users\\hyperboat\\Documents\\sort\\6.txt"));
    files.add(new File("C:\\Users\\hyperboat\\Documents\\sort\\7.txt"));
    files.add(new File("C:\\Users\\hyperboat\\Documents\\sort\\9.txt"));
    files.add(null);
    Collections.sort(files, new Comparator<File>() {
      @Override
      public int compare(File o1, File o2) {
//      if (o1 == null) {
//        return 1;
//      }
//      if (o2 == null) {
//        return -1;
//      }
        return (int) (o1.lastModified() - o2.lastModified());
      }
    });

    for (File file : files) {
      System.out.println(file == null ? null : file.getName() + file.lastModified());
    }
  }
}
