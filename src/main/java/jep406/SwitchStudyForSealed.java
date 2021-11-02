package jep406;

import jep406.sub1.IFlyable;
import jep406.sub1.Plane1;
import jep406.sub1.Plane2;
import jep406.sub1.Plane3;

public class SwitchStudyForSealed {

    public static void main(String[] args) {
        System.out.println(identify(new Plane3(4,5)));
    }

    public static String identify(IFlyable plane) {
        return switch (plane) {
            case Plane1 plane1 -> "This is plane1";
            case Plane2 plane2 -> "This is plane2";
            case Plane3 plane3 -> String.format("This is plane3, x=%d, y=%d", plane3.x(), plane3.y());
        };
    }

}
