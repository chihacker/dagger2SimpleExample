
import withdagger.CoffeeComponent;
import withdagger.CoffeeMakerModule;
import withdagger.DaggerCoffeeComponent;
import withdi.CoffeeMaker;
import withdi.Injection;

/**
 * Created by chihacker on 2017. 7. 27..
 */
public class CoffeeApp {


    public static void main(String[] args){

        //without DI
        //커피를 만들기 위해서는 어떤 Heater 를 사용해야 하고 어떤 Pump 를 사용해야 한다는 것을 알아야 한다.
        {
            withoutdi.Heater heater = new withoutdi.A_Heater(); // A_heater 를 사용해야한다는 것을 알아야 한다.
            withoutdi.Pump pump = new withoutdi.A_Pump(heater); // A_pump 를 사용해야 한다는 것을 알아야 한다.
            withoutdi.CoffeeMaker coffeeMaker = new withoutdi.CoffeeMaker(heater,pump);
            coffeeMaker.brew();
        }


        //with DI
        {
            //어떤 heater와 pump 가 필요한지 몰라도 된다. withdi.Injection class에 모두 정의 되어 있다.
            withdi.Heater heater = Injection.provideHeater(); // A_heater 가 필요한지 B_heater 가 필요한지 몰라도 된다.
            withdi.Pump pump = Injection.providePump(heater); // A_pump가 필요한지 B_pump가 필요한지 몰라도 된다.
            withdi.CoffeeMaker coffeeMaker = new withdi.CoffeeMaker(Injection.provideHeater(),Injection.providePump());
            coffeeMaker.brew();

            //또는 coffeemaker 자체를 injection class 에서 di 를 해줄수도 있다.
            Injection.provideCoffeeMaker().brew();
        }

        //with dagger
        //위의 DI 과정을 어노테이션을 활용하여 쉽게 할 수 있도록 도와준다.
        //간단한 이번 예시 뿐만 아니라 복잡한 구조에서도 간결하게 DI를 할 수 있도록 도와준다.
        {
            //provision method
            DaggerCoffeeComponent.create().make().brew();

            //member-injection method
            withdagger.CoffeeMaker coffeeMaker = new withdagger.CoffeeMaker();
            DaggerCoffeeComponent.create().inject(coffeeMaker);
            coffeeMaker.brew();
        }

    }
}
