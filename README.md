# ph-forbidden-apis
[Forbidden APIs](https://github.com/policeman-tools/forbidden-apis) signature for my projects.
They are mostly about style and performance and not so much about correctness.

# News and Noteworthy
  
  * v1.0.0 - 2017-03-29
    * Initial version containing `forbidden-apis.txt`

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
              <version>1.0.0</version>
              <type>jar</type>
              <path>forbidden-apis.txt</path>
            </signaturesArtifact>
          </signaturesArtifacts>
          <excludes>
             <!-- Example on how to exclude classes */
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

---

My personal [Coding Styleguide](https://github.com/phax/meta/blob/master/CodeingStyleguide.md) |
On Twitter: <a href="https://twitter.com/philiphelger">@philiphelger</a>
