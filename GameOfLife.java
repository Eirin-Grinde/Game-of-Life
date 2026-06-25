import java.util.Scanner;

// Entry point. Prompts the user for grid dimensions, creates a world,
// and simulates several generations.
public class GameOfLife {

    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Number of rows?");
        int row = scanner.nextInt();
        
        System.out.println("Number of columns?");
        int col = scanner.nextInt();
        scanner.close();

        // Create the simulation with user's dimensions.
        World world = new World(row, col);

        // Display initial generation.
        world.draw();

        // Simulate 3 generations.
        for (int i = 0;  i < 3;  ++i) {
            world.update();
        } 
    }
}
