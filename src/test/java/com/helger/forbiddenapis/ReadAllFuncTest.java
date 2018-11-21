/**
 * Copyright (C) 2016-2018 Philip Helger (www.helger.com)
 * philip[at]helger[dot]com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.helger.forbiddenapis;

import static de.thetaphi.forbiddenapis.Checker.Option.DISABLE_CLASSLOADING_CACHE;
import static de.thetaphi.forbiddenapis.Checker.Option.FAIL_ON_MISSING_CLASSES;
import static de.thetaphi.forbiddenapis.Checker.Option.FAIL_ON_UNRESOLVABLE_SIGNATURES;
import static de.thetaphi.forbiddenapis.Checker.Option.FAIL_ON_VIOLATION;

import java.io.File;
import java.io.IOException;
import java.util.EnumSet;

import org.junit.Test;
import org.slf4j.LoggerFactory;

import de.thetaphi.forbiddenapis.Checker;
import de.thetaphi.forbiddenapis.Logger;
import de.thetaphi.forbiddenapis.ParseException;

public final class ReadAllFuncTest
{
  private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger (ReadAllFuncTest.class);

  @Test
  public void testReadAll () throws IOException, ParseException
  {
    final Logger log = new Logger ()
    {
      @Override
      public void error (final String msg)
      {
        LOGGER.error (msg);
      }

      @Override
      public void warn (final String msg)
      {
        LOGGER.warn (msg);
      }

      @Override
      public void info (final String msg)
      {
        LOGGER.info (msg);
      }
    };

    final EnumSet <Checker.Option> options = EnumSet.noneOf (Checker.Option.class);
    options.add (FAIL_ON_MISSING_CLASSES);
    options.add (FAIL_ON_VIOLATION);
    options.add (DISABLE_CLASSLOADING_CACHE);
    if (false)
    {
      // Error when running Java 9 on the Java 8 fileset
      options.add (FAIL_ON_UNRESOLVABLE_SIGNATURES);
    }

    final Checker checker = new Checker (log, ClassLoader.getSystemClassLoader (), options);

    for (final File f : new File ("src/main/resources").listFiles ())
    {
      if (f.isFile () && f.getName ().endsWith (".txt"))
      {
        log.info (f.getAbsolutePath ());
        checker.parseSignaturesFile (f);
      }
    }
  }
}
