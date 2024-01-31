package oop1;

//i) Interfaces
interface IPrepareQuickly {
 void deliveryTime();
}

interface IPrepareDeliciously {
 void addFlavour();
 double getCost();
}

//ii) Flavour classes
class ChickenFlavour implements IPrepareDeliciously {
 @Override
 public void addFlavour() {
     System.out.println("Added Chicken for the meal");
 }

 @Override
 public double getCost() {
     return 100.0;
 }
}

class FishFlavour implements IPrepareDeliciously {
 @Override
 public void addFlavour() {
     System.out.println("Added Fish for the meal");
 }

 @Override
 public double getCost() {
     return 80.0;
 }
}

class EggFlavour implements IPrepareDeliciously {
 @Override
 public void addFlavour() {
     System.out.println("Added Egg for the meal");
 }

 @Override
 public double getCost() {
     return 60.0;
 }
}

//iii) Duration classes
class OneHour implements IPrepareQuickly {
 @Override
 public void deliveryTime() {
     System.out.println("Meal is ready in 60 minutes");
 }
}

class ThirtyMinutes implements IPrepareQuickly {
 @Override
 public void deliveryTime() {
     System.out.println("Meal is ready in 30 minutes");
 }
}

class FortyFiveMinutes implements IPrepareQuickly {
 @Override
 public void deliveryTime() {
     System.out.println("Meal is ready in 45 minutes");
 }
}

//iv) Abstract class Meal
abstract class Meal implements IPrepareQuickly, IPrepareDeliciously {
 private IPrepareQuickly prepareQuickly;
 private IPrepareDeliciously prepareDeliciously;

 public void setFlavour(IPrepareDeliciously flavour) {
     this.prepareDeliciously = flavour;
 }

 public void setDuration(IPrepareQuickly duration) {
     this.prepareQuickly = duration;
 }

 @Override
 public void deliveryTime() {
     prepareQuickly.deliveryTime();
 }

 @Override
 public void addFlavour() {
     prepareDeliciously.addFlavour();
 }

 @Override
 public double getCost() {
     return prepareDeliciously.getCost();
 }

 abstract void displayMeal();
 abstract void displayCost();
}

//v) Concrete Meal classes
class Breakfast extends Meal {
 @Override
 void displayMeal() {
     System.out.println("Preparing Breakfast......");
     addFlavour();
     deliveryTime();
     displayCost();
 }

 @Override
 void displayCost() {
     System.out.println("Cost for the meal is = " + getCost());
 }
}

class Lunch extends Meal {
 @Override
 void displayMeal() {
     System.out.println("Preparing Lunch......");
     addFlavour();
     deliveryTime();
     displayCost();
 }

 @Override
 void displayCost() {
     System.out.println("Cost for the meal is = " + getCost());
 }
}

class Dinner extends Meal {
 @Override
 void displayMeal() {
     System.out.println("Preparing Dinner......");
     addFlavour();
     deliveryTime();
     displayCost();
 }

 @Override
 void displayCost() {
     System.out.println("Cost for the meal is = " + getCost());
 }
}

//vi) Test class
public class TestStrategy {
 public static void main(String[] args) {
     Meal meal = new Breakfast();
     meal.setFlavour(new ChickenFlavour());
     meal.setDuration(new ThirtyMinutes());
     meal.displayMeal();

     Meal meal2 = new Lunch();
     meal2.setFlavour(new FishFlavour());
     meal2.setDuration(new OneHour());
     meal2.displayMeal();

     Meal meal3 = new Dinner();
     meal3.setFlavour(new EggFlavour());
     meal3.setDuration(new FortyFiveMinutes());
     meal3.displayMeal();
 }
}
