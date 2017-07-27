package withdagger;

import javax.inject.Inject;

/**
 * Created by chihacker on 2017. 7. 27..
 */

public class CoffeeMaker {
    public Heater heater;
    public Pump pump;

    @Inject
    public CoffeeMaker(Heater heater, Pump pump){
        this.heater = heater;
        this.pump = pump;
    }

    public void brew(){
        heater.on();
        pump.pump();
        System.out.println(" [_]P coffee! [_]P ");
        heater.off();
    }

    public Heater getHeater() {
        return heater;
    }

    public Pump getPump() {
        return pump;
    }
}
