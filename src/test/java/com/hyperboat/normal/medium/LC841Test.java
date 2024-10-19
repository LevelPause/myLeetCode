package com.hyperboat.normal.medium;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class LC841Test {

  @Test
  void canVisitAllRooms() {
    List<List<Integer>> rooms = new ArrayList<>();
    rooms.add(Stream.of(1).collect(Collectors.toList()));
    rooms.add(Stream.of(2).collect(Collectors.toList()));
    rooms.add(Stream.of(3).collect(Collectors.toList()));
    rooms.add(new ArrayList<>());
    assertTrue(new LC841().canVisitAllRooms(rooms));

    List<List<Integer>> rooms1 = new ArrayList<>();
    rooms1.add(Stream.of(1).collect(Collectors.toList()));
    rooms1.add(new ArrayList<>());
    rooms1.add(Stream.of(0,3).collect(Collectors.toList()));
    rooms1.add(Stream.of(1).collect(Collectors.toList()));

    assertFalse(new LC841().canVisitAllRooms(rooms1));
  }
}