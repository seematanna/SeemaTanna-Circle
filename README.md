# seematanna-Circle
Run the tests with Maven:
mvn clean test

The tests will execute in parallel, and you can view the test results in the target/cucumber-reports directory.

Customization
To adjust the level of parallelism, edit the testng.xml file and update the thread-count attribute to the desired number of threads:

<suite name="Cucumber Parallel Suite" verbose="1" parallel="tests" thread-count="5"> You can also add or remove elements in the testng.xml file to control the number of parallel test executions.

    ![CircleFramework](https://github.com/seematanna/seematanna-Circle/assets/144175446/4f63737b-e521-4308-a58f-bab836d9ce39)
