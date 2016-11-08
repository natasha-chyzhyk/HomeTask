/**
 * Created by Stas on 30.10.2016.
 */
public class Herbivorous {
    private String livingArea;
    private float age;
    private String name;
    private HerbalFood[] supportedFood;

    public Herbivorous(String livingArea, float age, String name, HerbalFood[] supportedFood) {
        this.livingArea = livingArea;
        this.age = age;
        this.name = name;
        this.supportedFood = supportedFood;
    }

    public String getLivingArea() {
        return livingArea;
    }

    public float getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public HerbalFood[] getSupportedFood() {
        return supportedFood;
    }

    public void eat(HerbalFood food){
        if (checkFoodSupported(food)) {
            System.out.println(getName()+ " eat " + food);
        }else{
            System.out.println(getName()+ " not eat " + food);
        }
    }

    private boolean checkFoodSupported(HerbalFood food) {
        for(int i = 0; i < supportedFood.length; i++){
            if(supportedFood[i] == food){
                return true;
            }
        }
        return false;
    }
}
