package com.vovamisjul.controller;

import com.google.gson.Gson;
import com.vovamisjul.model.CommunalServices;
import com.vovamisjul.model.IOSystem;
import com.vovamisjul.model.entities.House;
import com.vovamisjul.model.entities.HouseAddress;

import java.io.IOException;

public class CommunalServicesController extends CRUDController {
    private CommunalServices communalServices = new CommunalServices();
    final String controllerName = "s";
    public CommunalServicesController() {

    }

    @Override
    public void createEntity() {
        System.out.println("Enter city");
        var city = scanner.nextLine();
        System.out.println("Enter street");
        var street = scanner.nextLine();
        System.out.println("Enter house number");
        var number = scanner.nextLine();
        try {
            var intNumber = Integer.parseInt(number);
            communalServices.addHouse(new House(new HouseAddress(city, street, intNumber)));
        }
        catch (NumberFormatException e) {
            System.out.println("Wrong house number");
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void readEntity() {
        System.out.println(communalServices);
    }

    @Override
    public void updateEntity() {
        System.out.println("Enter city");
        var city = scanner.nextLine();
        System.out.println("Enter street");
        var street = scanner.nextLine();
        System.out.println("Enter house number");
        var number = scanner.nextLine();
        try {
            var intNumber = Integer.parseInt(number);
            new HouseController(communalServices.getHouse(new HouseAddress(city, street, intNumber))).run();
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        catch (Exception e) {
            System.out.println("Wrong house number");
        }
    }

    @Override
    public void deleteEntity() {
        System.out.println("Enter city");
        var city = scanner.nextLine();
        System.out.println("Enter street");
        var street = scanner.nextLine();
        System.out.println("Enter house number");
        var number = scanner.nextLine();
        try {
            var intNumber = Integer.parseInt(number);
            communalServices.deleteHouse(new HouseAddress(city, street, intNumber));
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        catch (Exception e) {
            System.out.println("Wrong house number");
        }
    }

    @Override
    public void sortEntities() {
    }

    @Override
    public void searchEntity() {
        System.out.println("Enter city");
        var city = scanner.nextLine();
        System.out.println("Enter street");
        var street = scanner.nextLine();
        System.out.println("Enter house number");
        var number = scanner.nextLine();
        try {
            var intNumber = Integer.parseInt(number);
            System.out.println(communalServices.getHouse(new HouseAddress(city, street, intNumber)));
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        catch (Exception e) {
            System.out.println("Wrong house number");
        }
    }

    @Override
    public void exit() {
        try {
            IOSystem.saveToFile(communalServices);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    String getSubentityName() {
        return "house";
    }

    @Override
    String getEntityName() {
        return "communal service";
    }

    @Override
    public void start() {
        try {
            communalServices = IOSystem.loadFromFile();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
