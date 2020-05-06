package com.supernova.bsc;

import com.supernova.bsc.component.PackageDelivery;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    String line;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    public void run(String... args) throws Exception {
        PackageDelivery packageDelivery = new PackageDelivery();
        if (args.length > 0) packageDelivery.initialize(args[0]);

        line = System.console().readLine();

        while (!line.equalsIgnoreCase("quit")) {

            if (line.equalsIgnoreCase("display")) {
                packageDelivery.printPackages();
            } else {
                try {
                    packageDelivery.addPackage(line);
                    System.out.println("Successfully added package " + line);
                } catch (NumberFormatException nfe) {
                    System.out.println("ERROR: Cannot add line " + line + ". Message: Parameter<Weight> is not a valid number");
                } catch (IllegalArgumentException iae) {
                    System.out.println("ERROR: Cannot add line " + line + ". Message: " + iae.getMessage());
                }
            }

            line = System.console().readLine();
        }
    }


}
