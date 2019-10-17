package com.vovamisjul.controller;

import com.vovamisjul.model.CommunalServices;
import com.vovamisjul.model.entities.House;
import com.vovamisjul.model.entities.HouseAddress;

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
    }

    @Override
    public void readEntity() {
        System.out.println(communalServices);
    }

    @Override
    public void updateEntity() {
        System.out.println("Enter number");
        var number = scanner.nextLine();
        try {
            var index = Integer.parseInt(number);
            new HouseController(communalServices.getHouse(index)).run();
        }
        catch (Exception e) {
            System.out.println("Wrong house number");
        }
    }

    @Override
    public void deleteEntity() {
        System.out.println("Enter number");
        var number = scanner.nextLine();
        try {
            var index = Integer.parseInt(number);
            communalServices.deleteHouse(index);
        }
        catch (Exception e) {
            System.out.println("Wrong house number");
        }
    }

    @Override
    String getEntityName() {
        return "house";
    }
}
