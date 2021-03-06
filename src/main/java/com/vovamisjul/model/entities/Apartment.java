package com.vovamisjul.model.entities;

import com.vovamisjul.model.entities.people.Person;
import com.vovamisjul.model.entities.people.Resident;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Apartment implements Serializable, Comparable<Apartment> {

    private final int number;

    private double powerConsumption = 0;
    private double hotWaterConsumption = 0;
    private double coldWaterConsumption = 0;
    private List<Resident> residents = new ArrayList<>();

    public Apartment() {
        number = 0;
    }

    public Apartment(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public double getPowerConsumption() {
        return powerConsumption;
    }

    public double getHotWaterConsumption() {
        return hotWaterConsumption;
    }

    public double getColdWaterConsumption() {
        return coldWaterConsumption;
    }

    public void sortResidents() {
        residents.sort(Person::compareTo);
    }

    public List<Resident> searchResidents(String name) {
        return residents.stream().filter((resident -> resident.getName().equals(name))).collect(Collectors.toList());
    }

    public void incPowerCons(double delta) {
        powerConsumption += delta;
    }

    public void incHotWaterCons(double delta) {
        hotWaterConsumption += delta;
    }

    public void incColdWaterCons(double delta) {
        coldWaterConsumption += delta;
    }

    public void resetConsumptions() {
        powerConsumption = hotWaterConsumption = coldWaterConsumption = 0;
    }

    public void addResident(Resident resident) {
        residents.add(resident);
    }

    public Resident getResident(int index){
        return residents.get(index);
    }

    @Override
    public String toString() {
        var result = new StringBuilder();
        result.append("Apartment ").append(number).append("\n").append("residents: ");
        if (residents.size() == 0) {
            result.append("empty \n");
        }
        else {
            for (var resident : residents
            ) {
                result.append(resident).append("\n");
            }
        }
        result.append("hot water consumption: ").append(hotWaterConsumption).append("\n");
        result.append("cold water consumption: ").append(coldWaterConsumption).append("\n");
        result.append("power consumption: ").append(powerConsumption);
        return result.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null || obj.getClass() != getClass())
            return false;
        var apartment = (Apartment)obj;
        return apartment.number == number &&
                apartment.powerConsumption == powerConsumption &&
                apartment.coldWaterConsumption == coldWaterConsumption &&
                apartment.hotWaterConsumption == hotWaterConsumption &&
                apartment.residents.equals(residents);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(number).append(powerConsumption).append(coldWaterConsumption)
                .append(hotWaterConsumption).append(residents).toHashCode();
    }

    @Override
    public int compareTo(Apartment o) {
        return Integer.compare(number, o.number);
    }
}
