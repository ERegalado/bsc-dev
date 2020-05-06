# H1 BSC Backend Developer Task
This repository contains the solution for the BSC Backend Developer Task. 

# H2 Instructions
1. Clone this repository into your local machine. 
2. Run maven command clean install. It will create a jar file into your target/ folder.
3. Navigate to the target folder and identify the jar. It will have a name similar to: "bsc-backend-dev-test-1.0-SNAPSHOT.jar"
4. Run the application from the Windows Command Prompt using: java -jar <Name-of-the-jar.jar> <Initialization-file>
Example:

```
java -jar "bsc-backend-dev-test-1.0-SNAPSHOT.jar" init-file.txt
```

The parameter init-file.txt is optional and represents an external file used to preload packages into the App.

# H2 Usage

![alt text](https://lh3.googleusercontent.com/Gn5LhNB-rOw8I4f6fBFZlZ1wpXfe81_uBDUC_AQy-OVcGlc316HdLSivxvmwMcXq4R0LuTw1jHDKEg=w1920-h988 "Usage")

1. The app will read the console infinitely until the keyword "quit" is found.
2. To add new packages, do it in the following format:

&lt;weight: positive number, &gt;0, maximal 3 decimal places, . (dot) as decimal
separator&gt;&lt;space&gt;&lt;postal code: fixed 5 digits&gt;

Example:
```
3.4 08801
2 90005
12.56 08801
```

3. The app has three validations. First, the number of parameters in each line should be exactly two. Second, the postal code must have 5 characters. Third, the weight should be a number.
4. Every minute the app will display the current packages ordered by weight desc. You may also type they keyword **display** in order to show the current packages. 
