import java.util.*; 

// Represents a single cell in Conway's Game of Life.
public class Cell {

    // A cell keeps track of whether it is alive, its neighbouring cells,
    // and updates its state according to the Game of Life rules.
    private List <Cell> neighbours = new ArrayList <Cell> ();
    private int livingNeighbourCount = 0;
    private boolean living; 

    // Creates a dead cell.
    public Cell (){ 
        this.living = false; 
    }

    // Mark cell as dead.
    public void setDead (){
        this.living = false;
    }

    // Marks cell as alive.
    public void setLiving (){
        this.living = true; 
    }

    // Returns life status of cell.
    public boolean isLiving(){
        return living;  
    }

    public int getLivingNeighbourCount(){
        return livingNeighbourCount;
    } 
    public int getNeighbourCount(){
        return neighbours.size();
    }

    // Returns character based on the life status of the cell.
    public char getStatusSign(){
        return living ? 'O' : '.';
    }

    // Adds another cell as a neighbour.
    public void addNeighbour(Cell neighbour){
        neighbours.add(neighbour);
    }

    // Counts the number of living neighbouring cells.
   public void countLivingNeighbours(){
        livingNeighbourCount = 0; 
        for (int i = 0; i < neighbours.size(); i++){
            if (neighbours.get(i).isLiving()){
                livingNeighbourCount ++; 
            }
        }
    }

    // Updates cell according to Conway's Game of Life rules.
    public void updateStatus(){
        if (living){
            if (livingNeighbourCount <2){
                setDead();
            }
            else if (livingNeighbourCount == 2 || livingNeighbourCount == 3){
                setLiving();
            }
            else {
                setDead();
            }
        }
        else {
            if (livingNeighbourCount == 3){
                setLiving();
            }
        }
    }
}
