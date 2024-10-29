public class Robot {
    private Direction direction;
    private int x;
    private int y;

    public Robot(Direction direction, int x, int y) {
        this.direction = direction;
        this.x = x;
        this.y = y;
    }

    public void move() {
        if (this.direction.equals(Direction.NORTH)) {
            this.y++;
            return;
        }

        if (this.direction.equals(Direction.EAST)) {
            this.x++;
        }

        if (this.direction.equals(Direction.SOUTH)) {
            this.y--;
        }

        if (this.direction.equals(Direction.WEST)) {
            this.x--;
        }
    }

    public void showCoordinates() {
        System.out.printf("%s -> (%d, %d)\n", this.direction, this.x, this.y);
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}