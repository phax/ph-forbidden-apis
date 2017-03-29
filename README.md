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
        <version>2.3</version>
        <configuration>
          <!-- if the used Java version is too new,
              don't fail, just do nothing:  -->
          <failOnUnsupportedJava>false</failOnUnsupportedJava>
          <bundledSignatures>
            <!-- Choose the right signatures based on 'maven.compiler.target': -->
            <bundledSignature>jdk-unsafe</bundledSignature>
            <bundledSignature>jdk-deprecated</bundledSignature>
            <!-- start 2.1 -->
            <bundledSignature>jdk-internal</bundledSignature>
            <bundledSignature>jdk-non-portable</bundledSignature>
            <!-- end 2.1 -->
            <bundledSignature>jdk-system-out</bundledSignature>
            <bundledSignature>jdk-reflection</bundledSignature>
          </bundledSignatures>
          <signaturesArtifacts>
            <signaturesArtifact>
              <groupId>com.helger</groupId>
              <artifactId>ph-forbidden-apis</artifactId>
              <version>1.0.0</version>
              <type>jar</type>
              <path>forbidden-apis.txt</path>
            </signaturesArtifact>
          </signaturesArtifacts>
          <excludes>
            <exclude>**/TestClassToExclude.class</exclude>
          </excludes>
        </configuration>
        <executions>
          <execution>
            <goals>
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

---

My personal [Coding Styleguide](https://github.com/phax/meta/blob/master/CodeingStyleguide.md) |
On Twitter: <a href="https://twitter.com/philiphelger">@philiphelger</a>
