package Interface;

import Point.Point2d;

import java.util.Collection;

public class Transform implements Rotate, Translate{
    /** TODO
     * Rotate all points of collections given in parameters
     * with the angle given
     * @param coords collections of Point2d
     * @param angle
     * @return rotated collection
     * */
    public Transform() {
    }
    public Collection<Point2d> rotate(Collection<Point2d> coords, Double angle) {
        Iterator var3 = coords.iterator();

        while(var3.hasNext()) {
            Point2d pointDD = (Point2d)var3.next();
            pointDD.rotate(angle);
        }

        return coords;
    }

    /** TODO
     * Translate all points of a collection by a given vector
     * @param coords Collection of Point2d
     * @param translateVector Vector of translation
     * @return translated coords
     * */
    public Collection<Point2d> translate(Collection<Point2d> coords, Point2d translateVector) {
        Iterator var3 = coords.iterator();

        while(var3.hasNext()) {
            Point2d pointDD = (Point2d)var3.next();
            pointDD.translate(translateVector);
        }

        return coords;
    }
}
