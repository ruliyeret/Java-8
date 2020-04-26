package Airport;

import java.util.ArrayList;
import java.util.List;

public class AirportMain {

    public static void main(String[] args){

        int systemId = 1000;
        List<Airplane> airplanes = new ArrayList<>(3);
        for (int i=0; i <3; i++){
            systemId += 100;
            airplanes.add(new Airplane(systemId));
            airplanes.get(i).start();

        }


    }
}
