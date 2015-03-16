Because maven can't download the necessary driver for mssql you have to follow these instructions:
1/ in this folder you'll find the sqljdbc4.jar file. copy it to some place else
2/ open cmd and run the following command:

mvn install:install-file -Dfile=sqljdbc4.jar -Dpackaging=jar -DgroupId=com.microsoft.sqlserver -DartifactId=sqljdbc4 -Dversion=4.0

it will create inside the repo folder the necessary files for mssql driver
3/ refresh maven
