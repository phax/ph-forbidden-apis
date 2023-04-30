# ph-forbidden-apis

[Forbidden APIs](https://github.com/policeman-tools/forbidden-apis) signature for my projects.
They are mostly about style and performance and not so much about correctness.

## Usage in Maven

Put a call to the forbidden-apis plugin and add this as a signatureArtifact:

```xml
  <build>
...
    <plugins>
...
      <plugin>
        <groupId>de.thetaphi</groupId>
        <artifactId>forbiddenapis</artifactId>
        <version>3.2</version>
        <configuration>
          <failOnUnsupportedJava>false</failOnUnsupportedJava>
          <bundledSignatures>
            <!-- Choose the right signatures based on 'maven.compiler.target' property: -->
            <bundledSignature>jdk-unsafe</bundledSignature>
            <bundledSignature>jdk-deprecated</bundledSignature>
            <bundledSignature>jdk-internal</bundledSignature>
            <bundledSignature>jdk-non-portable</bundledSignature>
            <bundledSignature>jdk-system-out</bundledSignature>
            <bundledSignature>jdk-reflection</bundledSignature>
          </bundledSignatures>
          <signaturesArtifacts>
            <!-- Finally add this artifact --> 
            <signaturesArtifact>
              <groupId>com.helger</groupId>
              <artifactId>ph-forbidden-apis</artifactId>
              <version>1.1.1</version>
              <type>jar</type>
              <path>forbidden-apis-java8.txt</path>
            </signaturesArtifact>
          </signaturesArtifacts>
          <excludes>
             <!-- Example on how to exclude classes -->
            <exclude>**/TestClassToExclude.class</exclude>
          </excludes>
        </configuration>
        <executions>
          <execution>
            <goals>
              <!-- Execute for main and test -->
              <goal>check</goal>
              <goal>testCheck</goal>
            </goals>
          </execution>
        </executions>
      </plugin>
...
    </plugins>
...
  </build>
```

Run the check explicitly (one of them):
```
mvn forbiddenapis:check
mvn forbiddenapis:testCheck
```


# News and Noteworthy

* v1.1.1 - 2018-03-28
  * Fixed a typo in Java9 file, and added a test for reading
* v1.1.0 - 2018-03-28
  * Changed filenames to `forbidden-apis-java8.txt` and `forbidden-apis-java9.txt`  
* v1.0.0 - 2017-03-29
  * Initial version containing `forbidden-apis.txt`

---

My personal [Coding Styleguide](https://github.com/phax/meta/blob/master/CodingStyleguide.md) |
It is appreciated if you star the GitHub project if you like it.