package com.hyperboat;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import org.junit.jupiter.api.Test;

/**
 * @author zhangweigang
 * @date 2022年07月04日 1:09
 */
class TestFile implements Runnable {

  @Test
  public void test() {
    for (int i = 0; i < 10; i++) {
      new TestFile().run();
    }
  }

  @Override
  public void run() {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    File bat = new File("C:\\Users\\hyperboat\\Desktop\\testFile.bat");
    System.out.println(bat.delete());
    try (PrintWriter writer = new PrintWriter(bat)) {
      writer.println("test file！");
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }
}
