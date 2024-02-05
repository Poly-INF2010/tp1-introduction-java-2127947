package Point;

public class Point2d extends AbstractPoint {
    private static final int X = 0;
    private static final int Y = 1;

    /** TODO
     * 2D Point Constructor from coordinates
     * @param x X coordinate
     * @param y Y coordinate
     */
    public Point2d(double x, double y) {
        super(new double[]{x, y});
    }

    /** TODO
     * 2D Point Constructor from vector
     * @param vector Vector containing X and Y coordinates
     */
    public Point2d(double[] vector) {
        super(vector);
    }

    /**
     * @return X coordinate
     */
    public double getX() {
        return vector[X];
    }

    /**
     * @return Y coordinate
     */
    public double getY() {
        return vector[Y];
    }

    /** TODO
     * Translate the point by the given vector
     * @param translateVector The vector by which to translate
     * @return Translated point
     */
    @Override
    public Point2d translate(double[] translateVector) {
        if (translateVector.length != 2) {
            throw new IllegalArgumentException("Translate vector must have two components");
        }
        return new Point2d(vector[X] + translateVector[X], vector[Y] + translateVector[Y]);
    }

    // Other methods...

    /** TODO
     * @return Deep copy of the 2D point
     */
    @Override
    public Point2d clone() {
        return new Point2d(vector[X], vector[Y]);
    }
}
