


import java.util.Scanner;
import java.util.Stack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Manny
 */
public class Maze {
    static int mazeWidth;
    static int mazeHeight;
    static Cell[][] map;
    boolean gameOver;
    boolean gameComplete;
    int playerCoordX;
    int playerCoordY;
    static boolean loggingEnabled = false;
    
    public Maze() {
        this.playerCoordX = 0;
        this.playerCoordY = 0;
        this.mazeWidth = 0;
        this.mazeHeight = 0;
        this.map = new Cell[0][0];
        this.gameComplete = false;
        this.gameOver = false;
    }

    public int getMazeWidth() {
        return mazeWidth;
    }

    public void setMazeWidth(int mazeWidth) {
        this.mazeWidth = mazeWidth;
    }

    public int getMazeHeight() {
        return mazeHeight;
    }

    public void setMazeHeight(int mazeHeight) {
        this.mazeHeight = mazeHeight;
    }

    public Cell[][] getMap() {
        return map;
    }

    public void setMap(Cell[][] map) {
        this.map = map;
    }
    
    public void drawMaze() {
        System.out.println("8 = PLAYER   X = EXIT");
        System.out.println();
        String line1 = "";
        String line2 = "";
        System.out.print("+");
        for(int i = 0; i < this.getMazeWidth(); i++) {
            System.out.print("---+");
        }
        System.out.println();
        for(int i = 0; i < this.getMazeHeight(); i++) {
            line1 = "|";
            line2 = "+";
            for(int ii = 0; ii < this.getMazeWidth(); ii++) {
                if(this.getPlayerCoordX() == ii && this.getPlayerCoordY() == i){
                    line1 += " 8 "; 
                } else if(this.getMap()[ii][i].isEnd == true){
                    line1 += " X ";
                } else {
                    line1 += "   ";
                }
                
                if(this.getMap()[ii][i].getWalls()[2] == 1) {
                    line1 += "|";
                } else {                    
                    line1 += " ";
                }
                
                if(this.getMap()[ii][i].getWalls()[1] == 1) {
                    line2 += "---+";
                } else {
                    line2 += "   +";
                }
                
                
            }
            
            System.out.println(line1);
            System.out.println(line2);
        }
        
        System.out.println();
    }
    
    public static Cell[][] generateMaze(int width, int height) {
        int currentCoordX = 0;
        int currentCoordY = 0;
        boolean mazeComplete = false;
        Stack cellStack = new Stack();
        Cell[][] maze = new Cell[width][height];
        int previousWallRemoved = -1;
        boolean finalCellMarked = false;
        
        while(mazeComplete == false) {
            log("Current Coords >> " + currentCoordX + ", " + currentCoordY);
            int[] validWalls = new int[]{0,0,0,0};
            Cell cell = new Cell();
            log("New cell has been created");
            cell.setCoordX(currentCoordX);
            cell.setCoordY(currentCoordY);
            if(currentCoordX == 0 && currentCoordY == 0) {
                log("Starting point");
                cell.setIsStart(true);
            }
            
            double mobProbability = Math.random();
            if(mobProbability <= .30) {
                log("Cell contains mob");
                cell.setMob(new Mob());
                cell.hasMob = true;
                cell.isMobDefeated = false;
            }
            
            
            maze[currentCoordX][currentCoordY] = cell;
            log("Added cell to maze at grid " + currentCoordX + ", " + currentCoordY);
            
            
            if(previousWallRemoved >= 0) {
                if(previousWallRemoved == 0) {
                    cell.getWalls()[1] = 0;
                    log("Removed South wall to previous cell");
                }
                if(previousWallRemoved == 1) {
                    cell.getWalls()[0] = 0;
                    log("Removed North wall to previous cell");
                }
                if(previousWallRemoved == 2) {
                    cell.getWalls()[3] = 0;
                    log("Removed West wall to previous cell");
                }
                if(previousWallRemoved == 3) {
                    cell.getWalls()[2] = 0;
                    log("Removed East wall to previous cell");
                }

            }
            
            boolean nextCellSelected = false;
            
            while(nextCellSelected == false) {
                if(currentCoordY > 0) {
                    if(maze[currentCoordX][currentCoordY - 1] == null) {
                        log("North is valid, 0");
                        validWalls[0] = 1;
                    }
                }

                if(currentCoordY < height - 1) {
                    if(maze[currentCoordX][currentCoordY + 1] == null) {
                        log("South is valid, 1");
                        validWalls[1] = 1;
                    }
                }

                if(currentCoordX < width - 1) {
                    if(maze[currentCoordX + 1][currentCoordY] == null) {
                        log("East is valid, 2");
                        validWalls[2] = 1;
                    }
                }

                if(currentCoordX > 0) {
                    if(maze[currentCoordX - 1][currentCoordY] == null) {
                        log("West is valid, 3");
                        validWalls[3] = 1;
                    }
                }
                if(validWalls[0] == 0 && validWalls[1] == 0 && validWalls[2] == 0 && 
                  validWalls[3] == 0) {
                    log("No valid walls can be removed");
                    if(cellStack.size() > 0) {
                        log("Stack popped");
                        previousWallRemoved = -1;
                        cell = (Cell) cellStack.pop();
                        currentCoordX = cell.getCoordX();
                        currentCoordY = cell.getCoordY();
                        log("Current cell has coords ");
                        log(cell.getCoordX() + ", " + cell.getCoordY());
                    } else {
                        log("Maze is complete");
                        mazeComplete = true;
                        maze[maze.length - 1][maze[0].length - 1].setIsEnd(true);
                        maze[maze.length - 1][maze[0].length - 1].setDescription(
                                maze[0][0].getEndDescription());
                        break;
                    }
                }
                
                else {
                    int random = (int) Math.ceil(Math.random() * 4) - 1;
                    if(validWalls[random] == 1) {
                        cell.getWalls()[random] = 0;
                        log("Removed wall at index " + random);
                        if(random == 0) {
                            currentCoordY--;
                        }
                        if(random == 1) {
                            currentCoordY++;
                        }
                        if(random == 2) {
                            currentCoordX++;
                        }
                        if(random == 3) {
                            currentCoordX--;
                        }
                        
                        log("Set coords at " + currentCoordX + ", " + currentCoordY);
                        previousWallRemoved = random;
                        log("previousWallRemoved set to " + previousWallRemoved);
                        nextCellSelected = true;
                        log("Next cell has been selected");
                    }
                }
            }
            
            cellStack.add(cell);
            log("Cell added to stack at position " + cellStack.size());
            log("");
            
        }
        
        return maze;  
    }
    
    public static void log(String log) {
        if(loggingEnabled == true) {
            System.out.println(log);
        }
        
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public boolean isGameComplete() {
        return gameComplete;
    }

    public void setGameComplete(boolean gameComplete) {
        this.gameComplete = gameComplete;
    }

    public int getPlayerCoordX() {
        return playerCoordX;
    }

    public void setPlayerCoordX(int playerCoordX) {
        this.playerCoordX = playerCoordX;
    }

    public int getPlayerCoordY() {
        return playerCoordY;
    }

    public void setPlayerCoordY(int playerCoordY) {
        this.playerCoordY = playerCoordY;
    }

    public static boolean isLoggingEnabled() {
        return loggingEnabled;
    }

    public static void setLoggingEnabled(boolean loggingEnabled) {
        Maze.loggingEnabled = loggingEnabled;
    }
};
