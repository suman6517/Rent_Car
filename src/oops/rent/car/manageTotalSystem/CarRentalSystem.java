package oops.rent.car.manageTotalSystem;

import oops.rent.car.Car;
import oops.rent.car.Customer;
import oops.rent.car.Rental;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarRentalSystem
{
    private List<Car>cars;
    private List<Customer>customers;
    private List<Rental>rentals;

    public CarRentalSystem()
    {
        this.cars = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.rentals = new ArrayList<>();
    }
    public void addCar(Car car)
    {
        cars.add(car);
    }
    public void addCustomer(Customer customer)
    {
        customers.add(customer);
    }
    public void rentCar(Car car ,Customer customer , int days)
    {
        if(car.isAvalable())
        {
            car.rent();
            rentals.add(new Rental(car , customer , days));
        }
        else
        {
            System.out.println("Car Is not available for the rent");
        }
    }
    public void returnCar(Car car)
    {
        Rental carToReturn = null;
       for(Rental rental : rentals)
       {
           if(rental.getCar() == car)
           {
               carToReturn = rental;
               break;
           }
       }
       if (carToReturn != null)
       {
           car.returnCar();
           rentals.remove(carToReturn);
           System.out.println("Car Returned Successfully");
       }
       else
       {
           System.out.println("Car does not return");
       }
    }
    public void showMenu()
    {
        try (Scanner scanner = new Scanner(System.in))
        {

            while (true)
            {
                System.out.println("====CAR RENTAL SYSTEM====");
                System.out.println("1: Rent A Car");
                System.out.println("2: Return The Car");
                System.out.println("3: EXIT");

                int choice = scanner.nextInt();
                scanner.nextLine();



                if (choice == 1)
                {
                    System.out.println("\n== Rent a Car ==\n");
                    System.out.print("Enter your name: ");
                    String customerName = scanner.nextLine();

                    System.out.println("\nAvailable Cars:");
                    for (Car car : cars)
                    {
                        if (car.isAvalable()) {
                            System.out.println(car.getCarId() + " - " + car.getBrand() + " " + car.getModel());
                        }
                    }

                    System.out.print("\nEnter the car ID you want to rent: ");
                    String carId = scanner.nextLine();

                    System.out.print("Enter the number of days for rental: ");
                    int rentalDays = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    Customer newCustomer = new Customer("CUS" + (customers.size() + 1), customerName);
                    addCustomer(newCustomer);

                    Car selectedCar = null;
                    for (Car car : cars)
                    {
                        if (car.getCarId().equals(carId) && car.isAvalable()) {
                            selectedCar = car;
                            break;
                        }
                    }


                    if (selectedCar != null)
                    {
                        double totalPrice = selectedCar.calculateRent(rentalDays);
                        System.out.println("\n== Rental Information ==\n");
                        System.out.println("Customer ID: " + newCustomer.getCusId());
                        System.out.println("Customer Name: " + newCustomer.getName());
                        System.out.println("Car: " + selectedCar.getBrand() + " " + selectedCar.getModel());
                        System.out.println("Rental Days: " + rentalDays);
                        System.out.printf("Total Price: $%.2f%n", totalPrice);

                        System.out.print("\nConfirm rental (Y/N): ");
                        String confirm = scanner.nextLine();

                        if (confirm.equalsIgnoreCase("Y")) {
                            rentCar(selectedCar, newCustomer, rentalDays);
                            System.out.println("\nCar rented successfully.");
                        } else {
                            System.out.println("\nRental canceled.");
                        }
                    }
                    else
                    {
                        System.out.println("\nInvalid car selection or car not available for rent.");
                    }


                }
                else if (choice == 2)
                {
                    System.out.println("\n== Return a Car ==\n");
                    System.out.print("Enter the car ID you want to return: ");
                    String carId = scanner.nextLine();

                    Car carToReturn = null;
                    for (Car car : cars) {
                        if (car.getCarId().equals(carId) && !car.isAvalable()) {
                            carToReturn = car;
                            break;
                        }
                    }

                    if (carToReturn != null) {
                        Customer customer = null;
                        for (Rental rental : rentals) {
                            if (rental.getCar() == carToReturn) {
                                customer = rental.getCustomer();
                                break;
                            }
                        }

                        if (customer != null) {
                            returnCar(carToReturn);
                            System.out.println("Car returned successfully by " + customer.getName());
                        } else {
                            System.out.println("Car was not rented or rental information is missing.");
                        }
                    } else {
                        System.out.println("Invalid car ID or car is not rented.");
                    }

                } else if (choice ==3)
                {
                    break;
                }
                else
                {
                    System.out.println("Invalid choice. Please enter a valid option.");
                }
                System.out.println("\nThank You For Using Our CarRetailSystem");

            }


        }
        catch (Exception exception)
        {
            System.out.println("There Is Something Wrong");
        }
    }


}
