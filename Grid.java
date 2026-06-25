// Represents the grid containing all cells.
// Creates cells, connects neighbours, draws the grid, and counts living cells.
public class Grid {
    
    private int rowCount;
    private int colCount; 
    private Cell[][] cells;

    // Creates an empty grid with the given dimensions. 
    public Grid(int row, int column) {
        rowCount = row;
        colCount = column;
        cells = new Cell [row][column]; 
    } 

    public int getRowCount(){
        return rowCount;
    }
    public int getColCount(){
        return colCount;
    }
    public Cell[][] getCells(){
        return cells;
    }

    // Creates a cell at specified positions. 
    public void makeCell(int row, int col){
    Cell c1 = new Cell(); 
    
    // 1/3 chance of cell starting out alive.
    if (Math.random() <=0.3333){
        c1.setLiving();
    }
    else { 
        c1.setDead();
    }
    cells[row][col] = c1; 
    }

    // Fills the grid with randomly initialized cells. 
    public void fillWithRandomCells(){
        for (int i = 0; i <rowCount; i++){
            for(int j = 0; j<colCount; j++){
                makeCell(i, j);
            }
        }
    }
    
    // Returns cell on specified position. 
    public Cell getCell(int row, int col){
        if (row < 0 || row >= rowCount || col < 0 || col >= colCount){
            return null;
        }
        else {
            return cells[row][col];
        }
    }

    // Prints current status of the grid. 
    public void drawGrid(){
        for (int i = 0; i < rowCount; i++){
            for(int j = 0; j <colCount; j++){
                Cell c1 = getCell(i, j);
                System.out.print("|" + c1.getStatusSign() + "|");
            }
            System.out.println(" ");
        }
    }

    // Finds and stores all valid neighbouring cells for specified cell.
    public void setNeighbours(int row, int col) {
        Cell c1 = getCell(row, col);
        if (c1 == null){
            return;
        }

        for (int i = row -1; i <= row + 1; i++){
            for (int j = col -1; j <= col + 1; j++){
                if (i == row && j == col){
                    continue;
                }

                Cell neighbour = getCell(i,j);
                if (neighbour != null){
                    c1.addNeighbour(neighbour);
                    //System.out.print("(" + i + "," + j + ")");
                }

            }
        }
    }

    // Connects every cell in the grid to its neighbours. 
    public void connectAllCells(){
        for (int i = 0; i < rowCount; i++){
            for (int j = 0; j < colCount; j++){
                setNeighbours(i,j);
            }
        }
    }

    // Counts the number of living cells in the grid. 
    public int countLiving(){
        int livingCount = 0;
        for (int i = 0; i < rowCount; i++){
            for (int j = 0; j < colCount; j++){
                if (getCell(i,j).isLiving()){
                    livingCount ++;
                }
            }
        }
        return livingCount;
    }
    
}
