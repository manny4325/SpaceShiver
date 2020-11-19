



import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Manny
 */
public class StartGame {
    static int mazeWidth;
    static int mazeHeight;
    static Maze maze;
    static boolean battleMode = false;
    static int playerHP = 100;
    
    public static void main(String[] args) {
        initializeMaze();
        
        while(maze.gameOver == false || maze.gameComplete == false) {
            game();
        }
        
    }
    
    public static void illustrateStartCell() {
        Scanner scanner = new Scanner(System.in);
        Cell currentCell = maze.getMap()[maze.getPlayerCoordX()][maze.getPlayerCoordY()];
            System.out.println(currentCell.getStartDescription());
            pauseText(1000);
            System.out.print("                     Press Enter to Continue...");
            scanner.nextLine();
            System.out.println();
    }
    
    public static void illustrateCell() {
        Scanner scanner = new Scanner(System.in);
        Cell currentCell = maze.getMap()[maze.getPlayerCoordX()][maze.getPlayerCoordY()];
        System.out.println(currentCell.getDescription());
        System.out.print("The room has doors leading >>");
        for(int i = 0; i < currentCell.getWalls().length; i++) {
            if(i == 0 && currentCell.getWalls()[i] == 0) {
                System.out.print(" | NORTH | ");
            }
            if(i == 1 && currentCell.getWalls()[i] == 0) {
                System.out.print(" | SOUTH | ");
            }
            if(i == 2 && currentCell.getWalls()[i] == 0) {
                System.out.print(" | EAST | ");
            }
            if(i == 3 && currentCell.getWalls()[i] == 0) {
                System.out.print(" | WEST | ");
            }
        }
        
        System.out.println();
        System.out.println();
        pauseText(1000);
    }
    
    public static void renderTitle() {
        try {
            Scanner scanner = new Scanner(System.in);
            Thread.sleep(1000);
            System.out.println("                  ░██████╗██████╗░░█████╗░░█████╗░███████╗");
            System.out.println("                  ██╔════╝██╔══██╗██╔══██╗██╔══██╗██╔════╝");
            System.out.println("                  ╚█████╗░██████╔╝███████║██║░░╚═╝█████╗░░");
            System.out.println("                  ░╚═══██╗██╔═══╝░██╔══██║██║░░██╗██╔══╝░░");
            System.out.println("                  ██████╔╝██║░░░░░██║░░██║╚█████╔╝███████╗");
            System.out.println("                 ╚═════╝░╚═╝░░░░░╚═╝░░╚═╝░╚════╝░╚══════╝");
            System.out.println();
            System.out.println();
            System.out.println();
            Thread.sleep(1000);
            System.out.println("               ░██████╗██╗░░██╗██╗██╗░░░██╗███████╗██████╗░");
            System.out.println("               ██╔════╝██║░░██║██║██║░░░██║██╔════╝██╔══██╗");
            System.out.println("               ╚█████╗░███████║██║╚██╗░██╔╝█████╗░░██████╔╝");
            System.out.println("               ░╚═══██╗██╔══██║██║░╚████╔╝░██╔══╝░░██╔══██╗");
            System.out.println("               ██████╔╝██║░░██║██║░░╚██╔╝░░███████╗██║░░██║");
            System.out.println("               ╚═════╝░╚═╝░░╚═╝╚═╝░░░╚═╝░░░╚══════╝╚═╝░░╚═╝");
            System.out.println();
            System.out.println();
            Thread.sleep(1000);
            
            System.out.println("                         A TEXT ADVENTURE GAME");
            System.out.println();
            Thread.sleep(1000);
            System.out.println("   If this is your first time playing, I strongly suggest a quick tutorial.");
            System.out.println("                      Would you like to see it now?\n");
            
            System.out.println("+--------------------------------------------------------------------+");
            System.out.println("|                       | YES |       | NO |                         |");
            System.out.println("+--------------------------------------------------------------------+\n");
            System.out.print(" >> ");

            String userInput = scanner.nextLine();
            System.out.println();
            boolean tutorialInputComplete = false;
            while(tutorialInputComplete == false) {
                if(userInput.equalsIgnoreCase("YES")) {
                    displayTutorial();
                    tutorialInputComplete = true;
                } else if(userInput.equalsIgnoreCase("NO")) {
                    tutorialInputComplete = true;
                } else {
                    System.out.println("Invalid input. Please try again.\n");
                }
            }
            
            System.out.println("          To begin, please enter your preferred maze dimensions.");
            System.out.println();
            System.out.println();
            Thread.sleep(750);
            
            boolean validInput = false;
            while(validInput == false) {
                try {
                    System.out.print("Enter maze width   >> ");
                    mazeWidth = scanner.nextInt();
                    System.out.print("Enter maze height  >> ");
                    mazeHeight = scanner.nextInt();
                    validInput = true;
                } catch(InputMismatchException e) {
                    System.out.println("Invalid input. Please try again.");
                    System.out.println();
                    scanner = new Scanner(System.in);
                }
            }
            
            
            
        } catch (InterruptedException ex) {
            Logger.getLogger(StartGame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void displayTutorial() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(
        "Welcome to Space Shiver, a text adventure game. This game consists of traversing \n"
        + "through a spaceship in hopes of reaching a mysterious room. The maze like \n"
        + "structure of the ship will be more confusing as the dimensions are increased. \n"
        + "When beginning the game, the user will be prompted fur width and height.\n\n"
        + "Example: \"Enter Width >> 5  |  Enter Height >> 5\" will create a 5x5 maze \n\n"
        + "Every room in the maze will provide a description of the room. The player \n"
        + "will then see possilble commands below the description.\n\n"
        + "| MOVE | \n\n "
        + "The move command allows the player to traverse the maze. \n\n"
        + "\t\tExample: >> MOVE EAST\n"
        + "\t\tExample: >> MOVE WEST\n\n"
        + "Every room will show you which directions of a room contain doors. You can \n"
        + "also refer to the map to find your way.\n\n"
        + "| FIGHT |\n\n"
        + "Occasionally you will encounter enemies within the rooms. When an enemy is \n"
        + "encountered, the | MOVE | command will be replaced with the | FIGHT | command. \n"
        + "Combat is turn based. After selecting the | FIGHT | command, you will attempt \n"
        + "to attack the enemy. The enemy will then attack you. These attacks take health \n"
        + "points away from the enemy and ultimately allow you to defeat them. \n\n"
        + "| INFO |\n\n"
        + "Displays the description of the room once more.\n\n"
        + "| MAP |\n\n"
        + "Provides a visual of the maze. The player is denoted by a | 8 | and the exit \n"
        + "by an | X |.\n\n"
        + "                    Display this information again?\n");
        
        System.out.print(">>");
        String userInput = scanner.nextLine();
        System.out.println();
        boolean tutorialInputComplete = false;
        while(tutorialInputComplete == false) {
            if(userInput.equalsIgnoreCase("YES")) {
                displayTutorial();
            } if(userInput.equalsIgnoreCase("NO")) {
                System.out.println("                             Good luck.\n");
                tutorialInputComplete = true;
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        }
    }
    
    public static void pauseText(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ex) {
            Logger.getLogger(StartGame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void displayCommands() {
        Cell currentCell = (Cell) maze.getMap()[maze.getPlayerCoordX()][maze.getPlayerCoordY()];
        System.out.println("-------------------------------------------------------------------");
        if(battleMode == true) {
            System.out.print("    | FIGHT |    | ENEMY |    ");
        } else {
            System.out.print("    | MOVE |    ");
        }
        System.out.print("| INFO |    ");
        if(currentCell.isIsEnd() == true) {
            System.out.print("| RING |    ");
        }
        System.out.println("| MAP |    ");
        System.out.println("-------------------------------------------------------------------\n");
        System.out.print(">> ");
        
        
                
    }
    
    public static void move(String direction) {
        int playerCoordX = maze.getPlayerCoordX();
        int playerCoordY = maze.getPlayerCoordY();
        
        if(direction.equalsIgnoreCase("NORTH")) {
            if(maze.getMap()[playerCoordX][playerCoordY] == null) {
                System.out.println("Invalid direction. Please try again.\n");
            } else if (maze.getMap()[playerCoordX][playerCoordY].getWalls()[0] == 1){
                System.out.println("Invalid direction. Please try again.\n");
            } else {
                maze.setPlayerCoordY(playerCoordY - 1);
                illustrateCell();
            }
        }
        
        else if(direction.equalsIgnoreCase("SOUTH")) {
            if(maze.getMap()[playerCoordX][playerCoordY] == null) {
                System.out.println("Invalid direction. Please try again.\n");
            } else if (maze.getMap()[playerCoordX][playerCoordY].getWalls()[1] == 1){
                System.out.println("Invalid direction. Please try again.\n");
            } else {
                maze.setPlayerCoordY(playerCoordY + 1);
                illustrateCell();
                
            }
        }
        else if(direction.equalsIgnoreCase("EAST")) {
            if(maze.getMap()[playerCoordX][playerCoordY] == null) {
                System.out.println("Invalid direction. Please try again.\n");
            } else if (maze.getMap()[playerCoordX][playerCoordY].getWalls()[2] == 1){
                System.out.println("Invalid direction. Please try again.\n");
            } else {
                maze.setPlayerCoordX(playerCoordX + 1);
                illustrateCell();
            }
        }
        else if(direction.equalsIgnoreCase("WEST")) {
            if(maze.getMap()[playerCoordX][playerCoordY] == null) {
                System.out.println("Invalid direction. Please try again.\n");
            } else if (maze.getMap()[playerCoordX][playerCoordY].getWalls()[3] == 1){
                System.out.println("Invalid direction. Please try again.\n");
            } else {
                maze.setPlayerCoordX(playerCoordX - 1);
                illustrateCell();
                if(maze.getMap()[playerCoordX][playerCoordY].hasMob) {
                    battleMode(maze.getMap()[playerCoordX][playerCoordY].getMob());
                }
            }
        }
    }
    
    public static void battleMode(Mob mob) {
        battleMode = true;
        System.out.println("A " + mob.getName() + " jumped out of the shadows!\n");
        System.out.println("The " + mob.getName() + " has " 
                            + mob.getHp() + " HP remaining.");
        System.out.println("You have " + playerHP + " HP remaining.\n");
        while(battleMode == true) {
            Scanner scanner = new Scanner(System.in);
            displayCommands();
            String command = scanner.nextLine();
            System.out.println();
            String[] bits = command.split(" ");

            if(bits[0].equalsIgnoreCase("MOVE")) {
                if(battleMode == true) {
                    System.out.println("You cannot move while under attack!\n");
                }
            } 

            else if(bits[0].equalsIgnoreCase("FIGHT")) {
                if(battleMode == true) {
                    int enemyDamage = (int) Math.ceil(Math.random() * 19);
                    int playerDamage = (int) Math.ceil(Math.random() * 10);
                    
                    if(enemyDamage <= 3) {
                        System.out.println("You swing at the " + mob.getName() + " but "
                                + "you stumble as you move.");
                        System.out.println("Inflicted 0 damage.\n");
                    }
                    
                    if(enemyDamage <= 15 && enemyDamage > 3) {
                        System.out.println("You swing at the " + mob.getName() + ". "
                                + "A decent strike.");
                        System.out.println("Inflicted " + enemyDamage + " damage.\n");
                        mob.setHp(mob.getHp() - enemyDamage);
                    }
                    
                    if(enemyDamage > 15) {
                        System.out.println("You swing at the " + mob.getName() + " with "
                                + "all your might. A direct hit!.");
                        System.out.println("Inflicted " + enemyDamage + " damage.\n");
                        mob.setHp(mob.getHp() - enemyDamage);
                    }
                    
                    pauseText(1000);
                    System.out.print("                Press Enter to Continue...");
                    scanner.nextLine();
                    System.out.println();
                    
                    if(playerDamage <= 3 && mob.getHp() > 0) {
                        System.out.println("The " + mob.getName() + " lunges at you "
                                + "but you roll out of the way.");
                        System.out.println("Inflicted 0 damage.\n");
                    }
                    
                    if(playerDamage <= 7 && playerDamage > 3 && mob.getHp() > 0) {
                        System.out.println("The " + mob.getName() + " lunges at you "
                                + "and lands a strike.");
                        System.out.println("Inflicted " + playerDamage + " damage.\n");
                        playerHP -= playerDamage;
                    }
                    
                    if(playerDamage > 7 && mob.getHp() > 0) {
                        System.out.println("You jump back as the " + mob.getName() + " attacks "
                                + "but lose your footing and fall. \nThe " + mob.getName() + " lands "
                                        + "a massive blow!");
                        System.out.println("Inflicted " + playerDamage + " damage.\n");   
                        playerHP -= playerDamage;
                    }
                    
                    pauseText(1000);
                }
                
                if(playerHP <= 0) {
                    loseGameSequence(mob);
                } else {
                    System.out.println("You have " + playerHP + "HP remaining.");
                }
                
                if(mob.getHp() <= 0) {
                    System.out.println("The " + mob.getName() + " has been defeated.\n");
                    battleMode = false;
                    maze.getMap()[maze.getPlayerCoordX()][maze.getPlayerCoordY()].setIsMobDefeated(true);
                } else {
                    System.out.println("The " + mob.getName() + " has " 
                            + mob.getHp() + " HP remaining. \n");
                }
            }

            else if(bits[0].equalsIgnoreCase("INFO")) {
                illustrateCell();
            } 

            else if(bits[0].equalsIgnoreCase("MAP")) {
                maze.drawMaze();
            }
            
            else if(bits[0].equalsIgnoreCase("ENEMY")) {
                System.out.println(mob.getDescription());
                System.out.println();
            }

            else {
                System.out.println("Invalid input. Please try again.\n");
            }
        }
    }
    
    public static void parseCommand(String command) {
        String[] bits = command.split(" ");
        boolean invalidInput = false;
        
        if(bits[0].equalsIgnoreCase("MOVE")) {
            if(battleMode == true) {
                System.out.println("You cannot run while under attack!\n");
            } else if(bits.length == 2) {
                if(bits[1].equalsIgnoreCase("NORTH") || bits[1].equalsIgnoreCase("SOUTH") ||
                    bits[1].equalsIgnoreCase("EAST") || bits[1].equalsIgnoreCase("WEST")) {
                    move(bits[1]);
                } else {
                    System.out.println("Invalid direction. Please try again.\n");
                }
            } else {
                System.out.println("Invalid input. Please try again.\n");
            }
        } 
        
        else if(bits[0].equalsIgnoreCase("FIGHT")) {
            if(battleMode == true) {
                int damage = (int) Math.ceil(Math.random() * 19);
            }
        }
        
        else if(bits[0].equalsIgnoreCase("INFO")) {
            illustrateCell();
        } 
        
        else if(bits[0].equalsIgnoreCase("MAP")) {
            maze.drawMaze();
        }
        
        else if(bits[0].equalsIgnoreCase("RING")) {
            winGameSequence();
        } 
        
        else {
            System.out.println("Invalid input. Please try again.\n");
        }
    }
    
    public static void winGameSequence() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(
                "You slowly enter the ring, a strange warmth encompassing you. As you \n"
                        + "go deeper into the light, the warmth turns into cold. So cold. \n"
                        + "The cold is almost too much to bear. You start screaming as you fall \n"
                        + "through the light, spinning faster and faster...\n");
        pauseText(3000);
        System.out.println("All of a sudden, silence...\n");
        pauseText(3000);
        System.out.println("Pain...ughh...this throbbing...where am I? \n"
                        + "You look around and find yourself in a strange room with tube-like \n"
                        + "containers. Disoriented and vision blurry, you struggle to make out \n"
                        + "what the words on the wall say...\"Cryogenic Containment Unit\". \n"
                        + "Cryogenic stasis? Why would you have been in hypersleep? This makes \n"
                        + "no sense...\n");
        pauseText(5000);
        
        System.out.print("                     Press any key to continue...");
        scanner.nextLine();
        
        System.out.println("+--------------------------------------------------------------------+");
        System.out.println("|                   C O N G R A T U L A T I O N S                    |");
        System.out.println("+--------------------------------------------------------------------+\n");
        System.out.println("      You have made it through this maze, but another awaits...");
        restart();
    }
    
    public static void loseGameSequence(Mob mob) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(
                "The " + mob.getName() + " proved too much for you to handle... your wounds\n"
                        + "are too great... you descend into darkness...\n");
        pauseText(3000);
        System.out.print("                     Press any key to continue...");
        scanner.nextLine();
        
        System.out.println("+--------------------------------------------------------------------+");
        System.out.println("|                       G A M E   O V E R                            |");
        System.out.println("+--------------------------------------------------------------------+\n");
        System.out.println("   You've failed this time, but this does not have to be the end...");
        restart();
    }
    
    public static void restart() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("                            Play again?\n");
        System.out.println("+--------------------------------------------------------------------+");
        System.out.println("|                       | YES |       | NO |                         |");
        System.out.println("+--------------------------------------------------------------------+\n");
        System.out.print(" >> ");
        
        String userInput = scanner.nextLine();
        boolean completed = false;
        
        while(completed == false) {
            if(userInput.equalsIgnoreCase("YES")) {
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                initializeMaze();
                completed = true;
            } else if(userInput.equalsIgnoreCase("NO")){
                System.out.println("                      Thanks for playing!\n");
                System.out.print("                     Press any key to exit...");
                scanner.nextLine();
                System.exit(0);
            } else {
                System.out.println("Please enter YES to replay, NO to exit game.\n");
                System.out.print(" >> ");
                userInput = scanner.nextLine(); 
            }
        }
        
        
        
    }
    
    public static void game() {
        while(maze.gameOver == false || maze.gameComplete == false) {
            Scanner scanner = new Scanner(System.in);
            Cell currentCell = maze.getMap()[maze.getPlayerCoordX()][maze.getPlayerCoordY()];
            if(currentCell.hasMob && currentCell.isMobDefeated == false) {
                battleMode(currentCell.getMob());
            }
            displayCommands();
            String userInput = scanner.nextLine();
            System.out.println();
            parseCommand(userInput);
        }
    }
    
    public static void initializeMaze() {
        renderTitle();
        System.out.println();
        
        playerHP = 100;
        maze = new Maze();
        maze.setMazeHeight(mazeHeight);
        maze.setMazeWidth(mazeWidth);
        maze.setMap(maze.generateMaze(mazeWidth, mazeHeight));
        illustrateStartCell();
        illustrateCell();
    }
}
