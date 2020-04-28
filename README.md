# Control Center SIM Lifecycle Management

This repo contains code sample that demonstrates how to invoke the Cisco IoT Control Center Devices REST API for a device (identified by its SIM) using Java to check the value of one attribute then change the value of another. In this case, the code sample retrieves information about the device status and changes the status of the device accordingly. You can also use the same construct to check on attributes like usage, zones, or sessions and change another attribute like SIM state. 

This is one of the most common use cases for the Control Center API and can be applied in a wide array of applications, including general SIM management as well as firmware updates, retail billing, security, and more.

# Prerequisites 
- JDK 8 or above
- Maven 3.3 or above
- Any IDE like Eclipse or Intellij
- A reservation in the Control Center Sandbox with a username and API Key

# Getting Started 

1. Request access to the Cisco IoT Control Center Sandbox from DevNet. You will receive a username and API Key for invoking the APIs. Please check the **[Getting Started](https://developer.cisco.com/docs/control-center/#!getting-started/getting-started)** section of our documentation for more details.

2. Copy all the files inside this SIM Lifecycle Management repository into a new repository or onto your local machine.

3. Generate your IDE-specific .project, .classpath, and .settings files. For example, for Eclipse, execute $ mvn eclipse:eclipse from the command prompt.

4. Import these files into your IDE.

5. Update the configuration based on your own setup, including your sandbox username, API Key, and proxy if required. The configuration is hosted in the java file src/main/java/com/cisco/jasper/util/Configuration.java.

6. Open the file src/main/java/com/cisco/jasper/Devices.java, which contains the application with different methods to invoke the Cisco IoT Control Center API calls. The output is printed at the console. E.g. json output of running the code for getting the device details is a follows,
    ```javascript
    {"pageNumber":1,"devices":[{"iccid":"9989203000880000201","status":"TEST_READY","ratePlan":"JPOTestDevnet","communicationPlan":"JPOTestDevnetCPEss"},{"iccid":"9989203000880000202","status":"TEST_READY","ratePlan":"JPOTestDevnet","communicationPlan":"JPOTestDevnetCPEss"}],"lastPage":true}
    ```

7. Explore the sample code to learn how to use the Cisco IoT Control Center Device REST APIs. You can use them to create your own applications—and [submit your code samples](https://developer.cisco.com/codeexchange/github/submit) to [DevNet CodeExchange](https://developer.cisco.com/codeexchange/)!

# Resources

- [APIs and documentation](https://developer.cisco.com/docs/control-center/#!rest-api-functions "APIs and documentation")
- [Control Center DevNet Microsite](https://developer.cisco.com/site/control-center/) (request sandbox access here)
- [Forum](https://community.cisco.com/t5/internet-of-things-iot/bd-p/4698j-disc-dev-iot) (submit your question with the tag “Control Center”)
- [Developer Support](https://developer.cisco.com/site/support/)
- [Submit code samples to CodeExchange](https://developer.cisco.com/codeexchange/github/submit)
