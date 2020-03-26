# Little Control Center Basics

The Control Centre (CC) is a platform for managing the lifecycle of IoT devices. A typical Device in CC is identified by SIM in it. Before being put to actual usage, the device needs to be onboarded and activated. When you sign up for CC APIs on DevNet, your account is provisioned with a couple of SIMs. This code sample demostrates how a devices  REST API can be invoked using Java to change status of a device. The device has a lot of properities and status is one of them.  For detailed overview please visit  **[Cisco IoT Control Center Overview](https://developer.cisco.com/docs/control-center/#!cisco-iot-control-center-overview/cisco-iot-control-center-overview "Control Center Overview")**.

You will need an API key for invoking the APIs. The API key can be obtained after signing for CC API from Cisco DevNet. Please check** [How to use APIs](https://developer.cisco.com/docs/control-center/#!getting-started/getting-started "How to use APIs")** for more details.  

# Pre-requisite 
1. JDK 8 or above
2. Maven 3.3 or above
3. Any IDE like Eclipse or Intellij

# Getting Started 

- Clone the repository to your local machine

- Execute the following from the command prompt to generate your IDE specific files. E.g. for eclilpse,

    $   mvn eclipse:eclipse


-  This will generate .project and .classpath project files which can be imported in Eclipse.

-  Once you import the files in Eclipse you are ready to go.

-  Before executing the code, you need to update the configuration as per your set up. The configuration is hosted in the java file  src/main/java/com/cisco/jasper/util/Configuration.java

- Update the username and API key that you recieved after sign up. Check if you need proxy or not and update the configuration accordingly. 

-  Now open the file src/main/java/com/cisco/jasper/Devices.java This class has different methods to invoke the respective API calls. 
	

# Resources

- [APIs and documentation](https://developer.cisco.com/docs/control-center/#!rest-api-functions "APIs and documentation")