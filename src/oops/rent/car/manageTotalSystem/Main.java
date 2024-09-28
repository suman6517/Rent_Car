package oops.rent.car.manageTotalSystem;

import oops.rent.car.Car;

public class Main
{
    public static void main(String[] args)
    {
        CarRentalSystem rentail = new CarRentalSystem();

        Car car1 = new Car("C01" , "Toyota" , "Fortuner",1000);
        Car car2 = new Car("C002", "Honda", "Accord", 700);
        Car car3 = new Car("C003", "Mahindra", "Thar", 500);
        rentail.addCar(car1);
        rentail.addCar(car2);
        rentail.addCar(car3);

        rentail.showMenu();
    }
}
