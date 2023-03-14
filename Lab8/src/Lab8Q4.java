import java.io.*;

public class Lab8Q4 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Car myCar = new Car("Toyota", "Camry", 2015, 50000, 20.0);
        File file = new File("Car.obj");

        //serialize
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(myCar);
        fileOutputStream.close();
        objectOutputStream.close();

        //deserialize
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Car newCar = (Car) objectInputStream.readObject();
        fileOutputStream.close();
        objectOutputStream.close();

        System.out.println(newCar);

    }
    static class Car implements Serializable {
        private String make;
        private String model;
        private int year;
        private int mileage;
        private double fuelLevel;

        public Car(String make, String model, int year, int mileage, double fuelLevel) {
            this.make = make;
            this.model = model;
            this.year = year;
            this.mileage = mileage;
            this.fuelLevel = fuelLevel;
        }

        public String getMake() {
            return make;
        }

        public void setMake(String make) {
            this.make = make;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public int getMileage() {
            return mileage;
        }

        public void setMileage(int mileage) {
            this.mileage = mileage;
        }

        public double getFuelLevel() {
            return fuelLevel;
        }

        public void setFuelLevel(double fuelLevel) {
            this.fuelLevel = fuelLevel;
        }

        public void drive(int distance) {
            mileage += distance;
            fuelLevel -= distance * 0.1;
        }

        public void fillUp(double amount) {
            fuelLevel += amount;
        }

        public String toString() {
            return year + " " + make + " " + model + ", mileage: " + mileage + ", fuel level: " + fuelLevel;
        }
    }
}



