package frontend.game_components;

import map_tracker.GameMapInitializer;

public class GameObject
{
    private final static int SIZE = 30;
    private int x;
    private int y;
    private int pixelsPerStep;

    protected GameObject(int x, int y, int pixelsPerStep) {
        this.x = x;
        this.y = y;
        this.pixelsPerStep = pixelsPerStep;
    }

    public enum Move
    {
        DOWN(0, 1),
        UP(0, -1),
        RIGHT(1, 0),
        LEFT(-1, 0);

        private final int deltaX;
        private final int deltaY;
        Move(final int deltaX, final int deltaY) {
            this.deltaX = deltaX;
            this.deltaY = deltaY;
        }
    }

    public void move(Move move) {
        y += move.deltaY * pixelsPerStep;
        x += move.deltaX * pixelsPerStep;
    }

    public void moveBack(Move currentDirection) {
        if (currentDirection == Move.DOWN) {
            move(Move.UP);
        } else if (currentDirection == Move.UP) {
            move(Move.DOWN);
        } else if (currentDirection == Move.LEFT) {
            move(Move.RIGHT);
        } else if (currentDirection == Move.RIGHT) {
            move(Move.LEFT);
        }
    }

    public int getSize() {
        return SIZE;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getColIndex() {
        return GameMapInitializer.pixelToSquare(x);
    }

    public int getRowIndex() {
        return GameMapInitializer.pixelToSquare(y);
    }
}
