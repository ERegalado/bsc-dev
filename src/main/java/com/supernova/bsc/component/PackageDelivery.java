package com.supernova.bsc.component;

import lombok.Getter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class PackageDelivery {

    final int PERIOD = 60000;

    @Getter
    private Map<String, Double> packages;

    public PackageDelivery() {
        packages = new HashMap<>();
        startTimer();
    }

    public void initialize(String fileName) throws IOException {
        Files.readAllLines(Paths.get(fileName)).forEach(this::addPackage);
    }

    public void addPackage(String line) throws IllegalArgumentException {
        String[] parts = line.split(" ");
        if (parts.length > 2)
            throw new IllegalArgumentException("The line should contain only two values: weight postal-code");
        if (parts[1].length() != 5)
            throw new IllegalArgumentException("The Postal Code should have exactly 5 characters");

        packages.put(parts[1], packages.get(parts[1]) != null ? Double.valueOf(parts[0]) + packages.get(parts[1]) :
                Double.valueOf(parts[0]));
    }

    private void startTimer() {
        Timer t = new Timer(true);
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                printPackages();
            }
        }, PERIOD, PERIOD);
    }

    public void printPackages() {
        System.out.println("The current packages are: ");
        packages.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).forEach(
                e -> System.out.println(e.getKey() + " " + e.getValue().toString()));
    }
}
