package withdi;

/**
 * Created by chihacker on 2017. 7. 27..
 */
public class Injection {
    public static Heater provideHeater(){
        return new A_Heater();
    }

    public static Pump providePump(){
        return new A_Pump(provideHeater());
    }

    public static CoffeeMaker provideCoffeeMaker(){
        return new CoffeeMaker(provideHeater(),providePump());
    }

    public static Pump providePump(Heater heater){
        return new A_Pump(heater);
    }


}
