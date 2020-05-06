package com.supernova.bsc;

import com.supernova.bsc.component.PackageDelivery;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class PackageDeliveryTest {

    @Test
    public void testInitialize() throws IOException {
        PackageDelivery packageDelivery = new PackageDelivery();

        packageDelivery.initialize("src/test/resources/init-file.txt");

        Assert.assertThat(packageDelivery.getPackages().size(), Matchers.equalTo(4));
        Assert.assertThat(packageDelivery.getPackages().get("08801"), Matchers.equalTo(15.96));
    }


    @Test
    public void testAddPackageSuccess() {
        PackageDelivery packageDelivery = new PackageDelivery();
        packageDelivery.addPackage("3.2 09300");
        Assert.assertThat(packageDelivery.getPackages().size(), Matchers.equalTo(1));
        Assert.assertNotNull(packageDelivery.getPackages().get("09300"));
        packageDelivery.addPackage("5.5 08079");
        Assert.assertThat(packageDelivery.getPackages().size(), Matchers.equalTo(2));
        Assert.assertNotNull(packageDelivery.getPackages().get("08079"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddPackageBadArgs() {
        PackageDelivery packageDelivery = new PackageDelivery();
        packageDelivery.addPackage("3.2 09300 96 36");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddPackageBadPostalCode() {
        PackageDelivery packageDelivery = new PackageDelivery();
        packageDelivery.addPackage("3.2 093");
    }

    @Test(expected = NumberFormatException.class)
    public void testAddPackageBadWeight() {
        PackageDelivery packageDelivery = new PackageDelivery();
        packageDelivery.addPackage("abc 09300");
    }
}
