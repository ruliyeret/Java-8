package FactoryPattern;

import FactoryPattern.model.Circle;

import java.awt.*;
import java.util.List;

public class playWithFactory {

    public static void main(String[] args){

        // create factory of circle without params
        iFactory factory = iFactory.createFactory(Circle::new);

        // create factory of circle with params
        iFactory factory2 = iFactory.createFactory(Circle::new, Color.RED);


        List<Circle> circleList = factory.createListOfInstances(5);
        System.out.println("circleList " + circleList) ;

    }
}
