package withdagger;


import dagger.Module;
import dagger.Provides;

/**
 * Created by chihacker on 2017. 7. 27..
 */
@Module
public class CoffeeMakerModule {

    @Provides
    Heater provideHeater(){
        return new A_Heater();
    }

    @Provides
    Pump providePump(Heater heater){
        return new A_Pump(heater);
    }

}
