import java.util.Scanner;

public class Play {
    public static void play() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Tentukan posisi awal Robot: (cont: E,2,3)");
        String[] initialInput = scanner.nextLine()
                                .replace(" ", "")
                                .replace("[", "")
                                .replace("]", "")
                                .split(",");

        if (initialInput.length != 3) {
            System.out.println("Input harus terdiri dari direction, x, dan y");
            return;
        }

        Direction direction = Direction.parseDirection(initialInput[0].toUpperCase());

        if (direction == null) {
            System.out.println("Direction harus salah satu dari N, E, S, W.");
            return;
        }

        if (!isNumeric(initialInput[1]) || !isNumeric(initialInput[2])) {
            System.out.println("Koordinat x dan y harus angka.");
            return;
        }

        char[] commandInput = scanner.nextLine().toCharArray();

        for (char command : commandInput) {
            if (command != 'A' && command != 'L' && command != 'R') {
                System.out.println("Input perintah hanya boleh berupa A, L, atau R.");
                return;
            }
        }

        Robot robot = new Robot(direction, Integer.parseInt(initialInput[1]), Integer.parseInt(initialInput[2]));

        for (char command : commandInput) {
            if (command == 'R') {
                robot.setDirection(robot.getDirection().turnRight());
                robot.showCoordinates();
            } else if (command == 'L') {
                robot.setDirection(robot.getDirection().turnLeft());
                robot.showCoordinates();
            } else {
                robot.move();
                robot.showCoordinates();
            }
        }
    }

    private static boolean isNumeric(String str) {
        return str.matches("-?\\d+");
    }
}