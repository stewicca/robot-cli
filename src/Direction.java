public enum Direction {
    NORTH("N"), EAST("E"), SOUTH("S"), WEST("W");

    final String desc;

    Direction(String desc) {
        this.desc = desc;
    }

    public static Direction parseDirection(String direction) {
        if (NORTH.desc.equals(direction)) {
            return NORTH;
        }

        if (EAST.desc.equals(direction)) {
            return EAST;
        }

        if (SOUTH.desc.equals(direction)) {
            return SOUTH;
        }

        if (WEST.desc.equals(direction)) {
            return WEST;
        }

        return null;
    }

    public Direction turnRight() {
        return Direction.values()[(this.ordinal() + 1) % Direction.values().length];
    }

    public Direction turnLeft() {
        return Direction.values()[(this.ordinal() + Direction.values().length - 1) % Direction.values().length];
    }
}