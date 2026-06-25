// Controls the Game of Life simulation.
public class World {
    private int genNr; 
    private Grid grid; 

    // Creates a new simulation world.
    public World(int rowCount, int colCount){
        grid = new Grid(rowCount, colCount);
        genNr = 0;
        grid.fillWithRandomCells();
        grid.connectAllCells();
    }

    public int getGenNr(){
        return genNr;
    }

    public Grid getGrid(){
        return grid;
    }

    // Prints the current generation and the number of living cells. 
    public void draw(){
        System.out.println("Generation nr: " + genNr);
        grid.drawGrid();
        System.out.println("Number of living cells: " + grid.countLiving());
    }
 
    public void update(){
        // Count living neighbours for every cell.
        for (int i = 0; i < grid.getRowCount(); i++){
            for (int j = 0; j < grid.getColCount(); j++){
                Cell c1 = grid.getCell(i,j);
                if (c1 != null){
                    c1.countLivingNeighbours();
                }
            }
        }

        // Update every cell after neighbour counts have been calculated.
        for (int i = 0; i < grid.getRowCount(); i++){
            for (int j = 0; j <grid.getColCount(); j++){
                Cell c1 = grid.getCell(i, j);
                if(c1 != null){
                    c1.updateStatus();
                }
            }
        }
        genNr ++;
        draw();
    }
}
