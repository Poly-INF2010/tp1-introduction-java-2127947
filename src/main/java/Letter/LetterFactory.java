package Letter;

import Point.Point2d;
import Shape.*;

public final class LetterFactory {
    final static Double maxHeight = 150.0;
    final static Double maxWidth = maxHeight / 2.5;
    final static Double halfMaxHeight = maxHeight / 2;
    final static Double halfMaxWidth = maxWidth / 2;
    final static Double stripeThickness = maxHeight / 8;
    final static Double halfStripeThickness = stripeThickness / 2;


    /** TODO
     * Create the letter A graphically
     * @return BaseShape containing the letter A
     */
    public static BaseShape create_A() {
        Rectangle r1 = new Rectangle(halfStripeThickness, maxHeight);
        Rectangle r2 = new Rectangle(halfStripeThickness, maxHeight);
        Rectangle r3 = new Rectangle(stripeThickness, halfStripeThickness);
        Point2d vt1 = new Point2d(-12.0,0.0);
        Point2d vt2 = new Point2d(12.0,0.0);
        Point2d vt3 = new Point2d(0.0,20.0);
        Double angle = Math.toRadians(8);
        r1.rotate(r1.getCoords(),angle);
        r2.rotate(r2.getCoords(),-angle);
        r1.translate(r1.getCoords(),vt1);
        r2.translate(r2.getCoords(),vt2);
        r3.translate(r3.getCoords(),vt3);


        return r1.add(r2).add(r3);



    }

    /** TODO
     * Create the letter B graphically
     * @return BaseShape containing the letter B
     */
    public static BaseShape create_B() {
        Rectangle r1 = new Rectangle(stripeThickness, maxHeight);
        Circle c1 = new Circle(halfMaxHeight + halfStripeThickness);
        Circle c2 = new Circle(halfMaxHeight + halfStripeThickness);
        Circle empty1 = new Circle(maxWidth);
        Circle empty2 = new Circle(maxWidth);


        Double[] pos1 = new Double[]{38.0, -35.0};
        Double[] pos2 = new Double[]{38.0, 35.0};

        for(Point2d coord : c1.getCoords()){
            coord.translate(pos1);
        }
        for(Point2d coord : c2.getCoords()){
            coord.translate(pos2);
        }
        for(Point2d coord : empty1.getCoords()){
            coord.translate(pos1);
        }
        for(Point2d coord : empty2.getCoords()){
            coord.translate(pos2);
        }
        c1.remove(empty1);
        c2.remove(empty2);
        r1.remove(c1);
        r1.remove(c2);

        return r1.add(c1).add(c2);
    }

    /** TODO
     * Create the letter C graphically
     * @return BaseShape containing the letter C
     */
    public static BaseShape create_C() {
        Rectangle rEmpty = new Rectangle(halfMaxWidth, halfMaxHeight+stripeThickness);
        Double[] vt1 = new Double[]{35.0, 0.0};
        for (Point2d coord : rEmpty.getCoords()) {
            coord.translate(vt1);

        }
        return new Ellipse(maxWidth+halfMaxWidth, maxHeight)
                .remove(new Ellipse((maxWidth+halfStripeThickness), (2*stripeThickness + halfMaxHeight+halfStripeThickness))).remove(rEmpty);
    }

    /** TODO
     * Create the letter E graphically
     * @return BaseShape containing the letter E
     */
    public static BaseShape create_E() {
        Rectangle r1 = new Rectangle(halfStripeThickness, maxHeight);
        Rectangle r2 = new Rectangle(stripeThickness, halfStripeThickness);
        Rectangle r3 = new Rectangle(stripeThickness*2, halfStripeThickness);
        Rectangle r4 = new Rectangle(stripeThickness*2, halfStripeThickness);

        Double[] v1 = {-15.0, 0.0};
        Double[] v2 = {15.0, 0.0};
        Point2d p = new Point2d(15.0, 0.0);
        Point2d p2 = new Point2d(15.0, 71.0);
        Point2d p3 = new Point2d(15.0, -71.0);

        r2.translate(r2.getCoords(), p);
        r3.translate(r3.getCoords(), p2);
        r4.translate(r4.getCoords(), p3);


        return ((r1.add(r2)).add(r3)).add(r4);

    }

    /** TODO
     * Create the letter H graphically
     * @return BaseShape containing the letter H
     */
    public static BaseShape create_H() {
        Rectangle r1 = new Rectangle(halfStripeThickness, maxHeight);
        Rectangle r2 = new Rectangle(halfStripeThickness, maxHeight);
        Rectangle r3 = new Rectangle(stripeThickness, halfStripeThickness);

        Double[] v1 = {-15.0, 0.0};
        Double[] v2 = {15.0, 0.0};

        for (Point2d pointDD : r1.getCoords()) {
            pointDD.translate(v1);
        }
        for (Point2d pointDD : r2.getCoords()) {
            pointDD.translate(v2);
        }

        return r1.add(r2).add(r3);
    }

    /** TODO
     * Create the letter N graphically
     * @return BaseShape containing the letter N
     */
    public static BaseShape create_N() {
        Rectangle r1 = new Rectangle(halfStripeThickness, maxHeight);
        Rectangle r2 = new Rectangle(halfStripeThickness, maxHeight);
        Rectangle r3 = new Rectangle(halfStripeThickness, maxHeight);

        Double[] v1 = {-27.0, 0.0};
        Double[] v2 = {27.0, 0.0};

        double angle = Math.toRadians(-22);


        for (Point2d pointDD : r1.getCoords()) {
            pointDD.translate(v1);
        }
        for (Point2d pointDD : r2.getCoords()) {
            pointDD.translate(v2);
        }

        for (Point2d pointDD : r3.getCoords()) {
            pointDD.rotate(angle);
        }

        return r1.add(r2).add(r3);
    }

    /** TODO
     * Create the letter O graphically
     * @return BaseShape containing the letter O
     */
    public static BaseShape create_O() {
        return new Ellipse(maxWidth+halfMaxWidth, maxHeight)
                .remove(new Ellipse((maxWidth+halfStripeThickness), (2*stripeThickness + halfMaxHeight+halfStripeThickness)));
    }

}
