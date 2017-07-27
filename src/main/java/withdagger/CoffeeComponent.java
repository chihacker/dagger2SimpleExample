package withdagger;


import dagger.Component;

/**
 * Created by chihacker on 2017. 7. 27..
 */

//
@Component(modules = CoffeeMakerModule.class)
public interface CoffeeComponent {
    CoffeeMaker make();
}
