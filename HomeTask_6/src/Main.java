public class Main {

    public static void main(String[] args) {
        Animal animal = new Animal("Dog", 2, "Home");
        System.out.println("Dog lives in the " +animal.getLivingArea());
        animal.sleep();
        animal.makeNoise();
        animal.setLivingArea("Street");
        System.out.println("Dog lives in the " +animal.getLivingArea());

        System.out.println("-----------------------");
        Predator predator = new Predator("Forest", 5, "Wolf", 4);
        System.out.println("Predator is " + predator.getName());
        System.out.println("Predator is " + predator.getAge() + " year");
        predator.eat();

        System.out.println("------------------------");
        HerbalFood[] herbalFoods = new HerbalFood[]{HerbalFood.GRASS, HerbalFood.APPLES, HerbalFood.CARROT};
        Herbivorous herbivorous = new Herbivorous("Country", 2, "Rabbit", herbalFoods);
        herbivorous.eat(HerbalFood.GRASS);
        herbivorous.eat(HerbalFood.NUTS);
    }
}
