Java Selenium Framework

Prerequisite :

1. Java should be Installed
2. Maven should be Installed.
3. Java and Maven path should be set under environment variable. 

Git Location:


Maven command to run:

1. Navigate to the Project root directory
	Ex : D:\AndersebLabs>
2. Run following cmd
	mvn test -DxmlFilePath=testng.xml


Framework: 
1. TestData Path : .\src\test\resources\TestData\TestData.xlsx
2. Screenshot Folder : ./screenshots/                      (Takes screenshot after every failed testcase with timestamp)
3. Reports : .\target\surefire-reports\Suite\Test.html