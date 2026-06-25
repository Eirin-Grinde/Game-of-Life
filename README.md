# Conway's Game of Life

A Java implementation of Conway's Game of Life created as part of an object-oriented programming course at the University of Oslo.

The program creates a grid of cells where each cell keeps track of its neighbouring cells and updates its state according to the Game of Life rules. The simulation starts with a randomly generated grid and displays several generations in the console.

## Features

* Object-oriented design
* Random generation of the initial grid
* Automatic neighbour detection
* Console-based simulation
* Generation-by-generation updates

## Project Structure

* **Cell** – Represents a single cell and determines whether it lives or dies based on its neighbours.
* **Grid** – Creates and manages the grid of cells and connects neighbouring cells.
* **World** – Controls the simulation and updates each generation.
* **GameOfLife** – Starts the program and handles user input.

## Conway's Game of Life Rules

For each generation:

* A living cell with fewer than two living neighbours dies.
* A living cell with two or three living neighbours survives.
* A living cell with more than three living neighbours dies.
* A dead cell with exactly three living neighbours becomes alive.

## Running the Program

Compile the source files:

```bash
javac *.java
```

Run the program:

```bash
java GameOfLife
```

You will be prompted to enter the number of rows and columns before the simulation starts.

## About the Project

This project was originally developed as part of university coursework. Before publishing it on GitHub, I updated the code by improving the naming, encapsulation, comments, and overall readability while keeping the original design and functionality.
