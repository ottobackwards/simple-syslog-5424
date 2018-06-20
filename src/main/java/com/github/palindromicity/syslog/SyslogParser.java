/*
 * Copyright 2018 simple-syslog-5424 authors
 * All rights reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.palindromicity.syslog;

import java.io.Reader;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * {@code SyslogParser} defines an interface for classes that parse Syslog into {@code Map}.
 */
public interface SyslogParser {

  /**
   * Parse a {@code String} to a {@code Map}.
   *
   * @param line the line of Syslog to parse
   * @return a {@code Map}
   * @throws com.github.palindromicity.syslog.dsl.ParseException if there is an error parsing
   */
  Map<String, Object> parseLine(String line);

  /**
   * Parse a {@code String} to a {@code Map} and provides that {@code Map} to the provided {@code Consumer}.
   *
   * @param line the line of Syslog to parser
   * @param consumer the {@code Consumer}
   * @throws com.github.palindromicity.syslog.dsl.ParseException if there is an error parsing
   */
  void parseLine(String line, Consumer<Map<String, Object>> consumer);

  /**
   * Reads each line from the {@code Reader} and parses it to a {@code List} of {@code Map}.
   *
   * @param reader {@code Reader} used.  It is not closed in this method.
   * @return {@code List} of {@code Map}
   * @throws com.github.palindromicity.syslog.dsl.ParseException if there is an error parsing
   */
  List<Map<String, Object>> parseLines(Reader reader);

  /**
   * Reads each line from the {@code Reader} and parses it to {@code Map}, which is passed to the
   * provided {@code Consumer}.
   *
   * @param reader {@code Reader} used.  It is not closed in this method.
   * @param consumer the {@code Consumer}
   * @throws com.github.palindromicity.syslog.dsl.ParseException if there is an error parsing
   */
  void parseLines(Reader reader, Consumer<Map<String, Object>> consumer);
}
