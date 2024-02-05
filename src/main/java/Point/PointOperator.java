package Point;

import java.util.*;

public final class PointOperator {
    public PointOperator(){
    }
    /** TODO
     * Translates a vector of size N by another vector of size N
     * Similar to adding two vector of size N together
     * @param vector Vector to translate
     * @param translateVector Translation to apply
     */
    public static void translate(Double[] vector, Double[] translateVector) {
        if (vector.length == translateVector.length) {
            for(int i = 0; i < vector.length; ++i) {
                vector[i] = vector[i] + translateVector[i];
            }

         }
    }

    /** TODO
     * Rotates a vector of size N by a matrix of size N x N
     * Similar to a matrix vector multiplication
     * @param vector Vector to rotate
     * @param rotationMatrix Matrix by which to rotate
     */
    public static void rotate(Double[] vector, Double[][] rotationMatrix) {
        if (vector.length == rotationMatrix.length) {
            Double[] resultVector = new Double[vector.length];

            for(int i = 0; i < vector.length; ++i) {
                double sum = 0.0;

                for(int j = 0; j < rotationMatrix[i].length; ++j) {
                    sum += vector[j] * rotationMatrix[i][j];
                }

                resultVector[i] = sum;
            }

            System.arraycopy(resultVector, 0, vector, 0, vector.length);
        }
    }

    /** TODO
     * Divide a vector of size N by a scalar
     * @param vector Vector to divide
     * @param divider Scalar by which to divide
     */
    public static void divide(Double[] vector, Double divider) {
        PointOperator.divide(this.vector, divider);
        return this;
    }

    /** TODO
     * Multiply a vector of size N by a scalar
     * @param vector Vector to multiply
     * @param multiplier Scalar by which to multiply
     */
    public static void multiply(Double[] vector, Double multiplier) {
        PointOperator.multiply(this.vector, multiplier);
        return this;
    }

    /** TODO
     * Add a scalar to a vector of size N
     * @param vector Vector that we have to add to
     * @param adder Scalar to add to vector
     */
    public static void add(Double[] vector, Double adder) {
        PointOperator.add(this.vector, adder);
        return this;
    }

    public Point2d clone() {return new Point2d(this.vector);
    }
}
