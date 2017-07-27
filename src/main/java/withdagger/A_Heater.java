package withdagger;

/**
 * Created by chihacker on 2017. 7. 27..
 */
public class A_Heater implements Heater {

    boolean heating;

    public A_Heater(){

    }

    public boolean isHeating() {
        return heating;
    }

    public void setHeating(boolean heating) {
        this.heating = heating;
    }

    public void on() {
        System.out.println("A_Heater : ~ ~ ~ heating ~ ~ ~");
        this.heating = true;
    }

    public void off() {
        this.heating = false;

    }

    public boolean isHot() {
        return heating;
    }
}
