package withoutdi;

/**
 * Created by chihacker on 2017. 7. 27..
 */
public class A_Pump implements Pump {
    private final Heater heater;

    public A_Pump(Heater heater) {
        this.heater = heater;
    }

    public void pump() {
        if (heater.isHot()) {
            System.out.println("A_Pump => => pumping => =>");
        }
    }
}
