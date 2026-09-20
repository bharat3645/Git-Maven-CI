# demo-app

A small Java project used to demonstrate Maven builds and a Jenkins pipeline.

## Layout

```
pom.xml                                     project definition and dependencies
src/main/java/com/demo/Calculator.java      the code
src/main/java/com/demo/App.java             a main() so the jar runs
src/test/java/com/demo/CalculatorTest.java  5 JUnit 5 tests
Jenkinsfile                                 pipeline: Build, Test, Package, Deploy
.gitignore                                  keeps target/ out of Git
```

## Build it

```
mvn clean package
java -jar target/demo-app-1.0.0-SNAPSHOT.jar
```

Expected output:

```
demo-app is running
2 + 3 = 5
10 / 2 = 5
```

## Break it on purpose

In `Calculator.java`, change `return a + b;` to `return a + b + 1;` and run `mvn clean package` again.

The build stops at the test phase with:

```
expected: <5> but was: <6>
BUILD FAILURE
```

and `target/` contains no jar. That is the point of a self-testing build.

## Run it in Jenkins

1. Manage Jenkins -> Tools -> Maven installations -> Add Maven. Name it exactly `Maven3`, tick Install automatically, save.
2. New Item, name it `demo-app`, choose Pipeline.
3. Under Pipeline, select Pipeline script from SCM, SCM Git, repository URL of this repo, branch `*/main`, script path `Jenkinsfile`.
4. Save, then Build Now.

The pipeline runs Build, Test, Package and Deploy, publishes the JUnit report and archives the jar.

On a Windows Jenkins agent, change every `sh` in the Jenkinsfile to `bat`.
