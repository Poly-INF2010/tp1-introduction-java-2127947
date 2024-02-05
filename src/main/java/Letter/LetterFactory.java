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
    public static BaseShape create_A()  {
        Rectangle r1 = new Rectangle(halfStripeThickness, maxHeight);
        Rectangle r2 = new Rectangle(halfStripeThickness, maxHeight);
        Rectangle r3 = new Rectangle(stripeThickness, halfStripeThickness);
        Double[] v1 = new Double[]{-15.0, 0.0};
        Double[] v2 = new Double[]{15.0, 0.0};
        Double[] v3 = new Double[]{0.0, -8.0};
        double angle = Math.toRadians(10.0);
        Iterator var8 = r1.getCoords().iterator();

        Point2d pointDD;
        while(var8.hasNext()) {
            pointDD = (Point2d)var8.next();
            pointDD.rotate(angle).translate(v1);
        }

        var8 = r2.getCoords().iterator();

        while(var8.hasNext()) {
            pointDD = (Point2d)var8.next();
            pointDD.rotate(-angle).translate(v2);
        }

        var8 = r3.getCoords().iterator();

        while(var8.hasNext()) {
            pointDD = (Point2d)var8.next();
            pointDD.translate(v3);
        }
        return r1.add(r2).add(r3);
    }

    /** TODO
     * Create the letter B graphically
     * @return BaseShape containing the letter B
     */
    public static BaseShape create_B() {
        Rectangle r1 = new Rectangle(halfStripeThickness, maxHeight);
        Circle c1 = new Circle(halfMaxHeight);
        Circle c2 = new Circle(halfMaxHeight);
        Point2d p1 = new Point2d(0.0, 40.0);
        Point2d p2 = new Point2d(0.0, -40.0);
        c1.translate(c1.getCoords(), p1);
        c2.translate(c1.getCoords(), p2);
        return r1.add(c1).add(c2);
    }

   /** TODO
     * Create the letter C graphically
     * @return BaseShape containing the letter C
     */
    public static BaseShape create_C() {
        return (new Ellipse(maxWidth, maxHeight)).remove(new Ellipse(halfMaxWidth, halfMaxHeight)); ;
    }

    /** TODO
     * Create the letter E graphically
     * @return BaseShape containing the letter E
     */
    public static BaseShape create_E() {
        Rectangle r1 = new Rectangle(halfStripeThickness, maxHeight);
        Rectangle r2 = new Rectangle(stripeThickness, halfStripeThickness);
        Rectangle r3 = new Rectangle(stripeThickness * 2.0, halfStripeThickness);
        Rectangle r4 = new Rectangle(stripeThickness * 2.0, halfStripeThickness);
        Double[] var10000 = new Double[]{-15.0, 0.0};
        var10000 = new Double[]{15.0, 0.0};
        Point2d p = new Point2d(15.0, 0.0);
        Point2d p2 = new Point2d(15.0, 71.0);
        Point2d p3 = new Point2d(15.0, -71.0);
        r2.translate(r2.getCoords(), p);
        r3.translate(r3.getCoords(), p2);
        r4.translate(r4.getCoords(), p3);
        return r1.add(r2).add(r3).add(r4);
    }

    /** TODO
     * Create the letter H graphically
     * @return BaseShape containing the letter H
     */
    public static BaseShape create_H() {
        Rectangle r1 = new Rectangle(halfStripeThickness, maxHeight);
        Rectangle r2 = new Rectangle(halfStripeThickness, maxHeight);
        Rectangle r3 = new Rectangle(stripeThickness, halfStripeThickness);
        Double[] v1 = new Double[]{-15.0, 0.0};
        Double[] v2 = new Double[]{15.0, 0.0};
        Iterator var5 = r1.getCoords().iterator();

        Point2d pointDD;
        while(var5.hasNext()) {
            pointDD = (Point2d)var5.next();
            pointDD.translate(v1);
        }

        var5 = r2.getCoords().iterator();

        while(var5.hasNext()) {
            pointDD = (Point2d)var5.next();
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
        Double[] v1 = new Double[]{-15.0, 0.0};
        Double[] v2 = new Double[]{15.0, 0.0};
        double angle = Math.toRadians(-10.0);
        Iterator var7 = r1.getCoords().iterator();

        Point2d pointDD;
        while(var7.hasNext()) {
            pointDD = (Point2d)var7.next();
            pointDD.translate(v1);
        }

        var7 = r2.getCoords().iterator();

        while(var7.hasNext()) {
            pointDD = (Point2d)var7.next();
            pointDD.translate(v2);
        }

        var7 = r3.getCoords().iterator();

        while(var7.hasNext()) {
            pointDD = (Point2d)var7.next();
            pointDD.rotate(angle);
        }

        return r1.add(r2).add(r3);
    }
    /** TODO
     * Create the letter O graphically
     * @return BaseShape containing the letter O
     */
    public static BaseShape create_O() {
        return (new Ellipse(maxWidth, maxHeight)).remove(new Ellipse(halfMaxWidth, halfMaxHeight));
    }
    static {
        maxWidth = maxHeight / 2.5;
        halfMaxHeight = maxHeight / 2.0;
        halfMaxWidth = maxWidth / 2.0;
        stripeThickness = maxHeight / 8.0;
        halfStripeThickness = stripeThickness / 2.0;
    }
}

