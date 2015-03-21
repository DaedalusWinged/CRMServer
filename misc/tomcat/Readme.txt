Guide on how to use tomcat8.rar file.
=====================================

1/ Extract the content of the rar file.
2/ Set up configuration files.
      i/ conf/server.xml contains the port in which server will listen (default = 8080).
     ii/ conf/Catalina/localhost/ROOT.xml has an attribute docBase that points to the CRMServer.war file. Change the path so it will point to that file.
    iii/ conf/Catalina/localhost/wsServer.xml has also the attribute docBase. This time it should be the full path to target/CRMServer.
     iv/ bin/catalina.bat or bin/catalina.sh must have in the first line the following command: set JAVA_HOME = Your_JDK_Path.
3/ Double click the bin/startup.bat or bin/startup.sh. Command line should start loading the necessary dependencies. You should also see ConnBroker being instantiated and retrieving the sqlite constants.
4/ Wait until server starts.
5/ Open a browser and go to: localhost:port_number/wsServer/userOperationService to check if everything is in order.

That's it. Now you can ask for a web service without starting an IDE.