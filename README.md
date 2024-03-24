# Learn how to use Mockito and JUnit to test your code

This project is used to show how to mock testing with Mockito and JUnit.

- [Mockito](https://github.com/mockito/mockito)
- [JUnit](https://github.com/junit-team/)

## Dependencies

Maven dependencies to be included in the `pom.xml` file are:

- JUnit Jupiter Engine
- Mockito Core
- Mockito JUnit Jupiter

```xml
    <dependencies>
    
<!-- https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-engine -->
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-engine</artifactId>
            <version>5.10.2</version>
            <scope>test</scope>
        </dependency>
        
<!-- https://mvnrepository.com/artifact/org.mockito/mockito-core -->
        <dependency>
            <groupId>org.mockito</groupId>
            <artifactId>mockito-core</artifactId>
            <version>5.11.0</version>
            <scope>test</scope>
        </dependency>

<!-- https://mvnrepository.com/artifact/org.mockito/mockito-junit-jupiter -->
        <dependency>
            <groupId>org.mockito</groupId>
            <artifactId>mockito-junit-jupiter</artifactId>
            <version>5.11.0</version>
            <scope>test</scope>
        </dependency>

    </dependencies>
```

## Creating Mock tests

The tests are created in the `src/test/java` directory.

Example using `@Mock`:

```java
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class MyTest {
    @Mock
    private MyInterface myInterface;
    @BeforeEach
    public void setUp() {
        when(myInterface.doSomething()).thenReturn("mocked");
    }
    @Test
    public void test() {
        // test
        assertEquals("mocked", myInterface.doSomething());
    }
    @AfterEach
    public void tearDown() {
        verify(myInterface, times(1)).doSomething();
    }
    @AfterAll
    public static void tearDownAll() {
        verifyNoMoreInteractions(myInterface);
    }
    @BeforeAll
    public static void setUpAll() {
        when(myInterface.doSomething()).thenReturn("mocked");
    }
    @Disabled
    @Test
    public void disabledTest() {
        // test
        assertEquals("mocked", myInterface.doSomething());
    }
}
```

## Spying objects (observe behavior)

Observe the object behavior when using Mockito spy.

## Capturing arguments

Captor is used to capture arguments passed to a method.

## Manipulating return values

Argument matchers are used to match arguments passed to a method.

Stubbing is used to mock return values of a method.

## Mocking static methods



## Troubleshooting

When running the test, sometimes an error like this may appear:
`WARNING: A Java agent has been loaded dynamically (/home/$USER/.m2/repository/net/bytebuddy/byte-buddy-agent/1.14.12/byte-buddy-agent-1.14.12.jar)`

Solution:

https://stackoverflow.com/questions/77951485/getting-a-java-agent-has-been-loaded-warning-in-intellij-after-upgrading-jdk-17

Add this to the pom.xml file:

```xml
<build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>3.2.5</version>
                <configuration>
<!--                    For Mockito - avoid errors like "A Java agent has been loaded dynamically" -->
                    <argLine>-XX:+EnableDynamicAgentLoading</argLine>
                </configuration>
            </plugin>
        </plugins>
    </build>
```
This error may also appear:
`OpenJDK 64-Bit Server VM warning: Sharing is only supported for boot loader classes because bootstrap classpath has been appended`

Solution: Just ignore it. It just means that class data sharing is disabled for classes not loaded by the bootstrap class loader.


