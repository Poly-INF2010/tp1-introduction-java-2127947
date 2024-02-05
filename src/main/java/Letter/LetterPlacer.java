package Letter;

import Point.Point2d;
import Shape.BaseShape;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;
import java.util.stream.Collectors;

public class LetterPlacer {
    private static final int ENLARGE_FACTOR = 3;
    private static final double PADDING = 20.0;
    private static final int MAX_COLOR = 256;

    private int numberOfLines = 1;
    private final Collection<Collection<Point2d>> shapes = new ArrayList<>();
    private BaseShape previousLetter = null;

    public void placeNext(char letter) throws IllegalArgumentException {
        BaseShape nextLetter = getNextLetter(letter);
        double horizontalPadding = (previousLetter != null) ? previousLetter.getMaxX() + PADDING : PADDING;
        previousLetter = insertShape(nextLetter, new Point2d(horizontalPadding, (numberOfLines - 1) * LetterFactory.maxHeight + numberOfLines * PADDING));
    }

    public void placeNextln(char letter) throws IllegalArgumentException {
        BaseShape nextLetter = getNextLetter(letter);
        previousLetter = insertShape(nextLetter, new Point2d(PADDING, (numberOfLines++) * LetterFactory.maxHeight + numberOfLines * PADDING));
    }

    private BaseShape getNextLetter(char letter) throws IllegalArgumentException {
        switch (letter) {
            case 'A':
                return LetterFactory.create_A();
            case 'B':
                return LetterFactory.create_B();
            case 'C':
                return LetterFactory.create_C();
            case 'E':
                return LetterFactory.create_E();
            case 'H':
                return LetterFactory.create_H();
            case 'N':
                return LetterFactory.create_N();
            case 'O':
                return LetterFactory.create_O();
            default:
                throw new IllegalArgumentException("Invalid letter: " + letter);
        }
    }

    private static int getRandomRGB() {
        Random rand = new Random();
        return rand.nextInt(MAX_COLOR) * 0x010000 +
                rand.nextInt(MAX_COLOR) * 0x000100 +
                rand.nextInt(MAX_COLOR);
    }

    private static int getWhite() {
        return 0xFFFFFF;
    }

    private BaseShape insertShape(BaseShape nextLetter, Point2d nextPosition) {
        Point2d center = new Point2d(-(nextLetter.getMaxX() + nextLetter.getMinX()) / 2.0, -(nextLetter.getMaxY() + nextLetter.getMinY()) / 2.0);
        nextLetter.replaceAll(nextLetter.translate(nextLetter.getCoords(), center));
        nextLetter.replaceAll(nextLetter.translate(nextLetter.getCoords(), nextLetter.getMaxCoord()));
        nextLetter.replaceAll(nextLetter.translate(nextLetter.getCoords(), nextPosition));
        shapes.add(nextLetter.getCoords());
        return nextLetter;
    }

    public File saveImage(String fileName, boolean saveInWhite) throws IOException {
        Point2d max = new BaseShape(shapes.stream().flatMap(Collection::stream).collect(Collectors.toList())).getMaxCoord();
        int[][] pixels = new int[(int)(max.Y() + PADDING)][(int)(max.X() + PADDING)];
        for (Collection<Point2d> coords : shapes) {
            int color = saveInWhite ? getWhite() : getRandomRGB();
            for (Point2d point : coords) {
                enlarge(pixels, (int)Math.round(point.Y()), (int)Math.round(point.X()), color);
            }
        }

        BufferedImage img = new BufferedImage(pixels[0].length, pixels.length, BufferedImage.TYPE_INT_RGB);
        int[] flatPixels = Arrays.stream(pixels).flatMapToInt(Arrays::stream).toArray();
        img.setRGB(0, 0, pixels[0].length, pixels.length, flatPixels, 0, pixels[0].length);
        File imgFile = new File(fileName + ".jpg");
        ImageIO.write(img, "jpg", imgFile);
        return imgFile;
    }

    private void enlarge(int[][] pixels, int y, int x, int color) {
        for (int i = -ENLARGE_FACTOR; i <= ENLARGE_FACTOR; ++i) {
            for (int j = -ENLARGE_FACTOR; j <= ENLARGE_FACTOR; ++j) {
                try {
                    pixels[j + y][i + x] = color;
                } catch (ArrayIndexOutOfBoundsException ignored) {
                }
            }
        }
    }
}
