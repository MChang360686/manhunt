import java.util.Scanner;
import java.util.Random;

public class Manhunt{
    /*
    based off a few videos by The Chasseur aka Chass
    https://www.youtube.com/watch?v=DFGy0va8rDU
    https://www.youtube.com/watch?v=b3CPesKTMX8
     */

    Random rand = new Random();
    Scanner scan = new Scanner(System.in);
    int computer = rand.nextInt(3) + 1;
    int player;
    int caseNumber = 0;
    boolean rollAgain = true;
    boolean computerGoesFirst = false;

    public boolean goesFirst(){
        rollAgain = true;
        while(rollAgain == true) {
            System.out.println("Choose a flare to shoot off");
            System.out.println("Red (1), Yellow(2), Green(3)");
            player = scan.nextInt();

            if(player == 1 && computer == 2){
                caseNumber = 1;
            }else if(player == 2 && computer == 3){
                caseNumber = 2;
            }else if(player == 3 && computer == 1){
                caseNumber = 3;
            }else if(player == 1 && computer == 3){
                caseNumber = 4;
            }else if(player == 2 && computer == 1){
                caseNumber = 4;
            }else if(player == 3 && computer == 2){
                caseNumber = 4;
            }else{
                caseNumber = 5;
            }

            switch(caseNumber){
                case 1:{
                    System.out.println("Red trump Yellow, Player goes first");
                    //System.out.println(computer);
                    computerGoesFirst = false;
                    rollAgain = false;
                    break;
                }
                case 2:{
                    System.out.println("Yellow trump Green, Player goes first");
                    //System.out.println(computer);
                    computerGoesFirst = false;
                    rollAgain = false;
                    break;
                }
                case 3:{
                    System.out.println("Green trump Red, Player goes first");
                    //System.out.println(computer);
                    computerGoesFirst = false;
                    rollAgain = false;
                    break;
                }
                case 4:{
                    System.out.println("Computer goes first");
                    //System.out.println(computer);
                    computerGoesFirst = true;
                    rollAgain = false;
                    break;
                }
                case 5:{
                    System.out.println("Both flares the same, roll again");
                    rollAgain = true;
                    break;
                }
                default:{
                    System.out.println(computer);
                    rollAgain = false;
                    break;
                }
            }
        }
        return computerGoesFirst;
    }

    public static void printOpponentField(char[][] opponentField){
        for(char[] row : opponentField){
            for(char c : row){
                System.out.print(c);
            }
            System.out.println();
        }
    }
    public static void printPlayerField(char[][] playerField){
        for(char[] row : playerField){
            for(char c : row){
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public int setComputerHealth(){
        System.out.println("Enter a number to set computer hp");
        int computerHealth = scan.nextInt();
        return computerHealth;
    }

    public int setPlayerHealth(){
        System.out.println("Enter a number to set player hp");
        int playerHealth = scan.nextInt();
        return playerHealth;
    }

    public static void attackOpponent(char[][] opponentField, int position){
        switch(position){
            case 1:{
                opponentField[0][0] = 'X';
                break;
            }
            case 2:{
                opponentField[0][2] = 'X';
                break;
            }
            case 3:{
                opponentField[0][4] = 'X';
                break;
            }
            case 4:{
                opponentField[2][0] = 'X';
                break;
            }
            case 5:{
                opponentField[2][2] = 'X';
                break;
            }
            case 6:{
                opponentField[2][4] = 'X';
                break;
            }
            case 7:{
                opponentField[4][0] = 'X';
                break;
            }
            case 8:{
                opponentField[4][2] = 'X';
                break;
            }
            case 9:{
                opponentField[4][4] = 'X';
                break;
            }
        }

    }

    public static void attackPlayer(char[][] playerField, int computerAttack){
        switch(computerAttack){
            case 1:{
                playerField[0][0] = 'X';
                break;
            }
            case 2:{
                playerField[0][2] = 'X';
                break;
            }
            case 3:{
                playerField[0][4] = 'X';
                break;
            }
            case 4:{
                playerField[2][0] = 'X';
                break;
            }
            case 5:{
                playerField[2][2] = 'X';
                break;
            }
            case 6:{
                playerField[2][4] = 'X';
                break;
            }
            case 7:{
                playerField[4][0] = 'X';
                break;
            }
            case 8:{
                playerField[4][2] = 'X';
                break;
            }
            case 9:{
                playerField[4][4] = 'X';
                break;
            }
        }

    }

    public static void resetGrid(char opponentField[][], char playerField[][]){
        opponentField[0][0] = ' ';
        opponentField[0][2] = ' ';
        opponentField[0][4] = ' ';
        opponentField[2][0] = ' ';
        opponentField[2][2] = ' ';
        opponentField[2][4] = ' ';
        opponentField[4][0] = ' ';
        opponentField[4][2] = ' ';
        opponentField[4][4] = ' ';
        playerField[0][0] = ' ';
        playerField[0][2] = ' ';
        playerField[0][4] = ' ';
        playerField[2][0] = ' ';
        playerField[2][2] = ' ';
        playerField[2][4] = ' ';
        playerField[4][0] = ' ';
        playerField[4][2] = ' ';
        playerField[4][4] = ' ';

    }

    public static void main(String[] args){
        boolean win = false;

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        Manhunt manhunt = new Manhunt();


        char opponentField [][] = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};
        char playerField [][] = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};

        int computerHealth = manhunt.setComputerHealth();
        int playerHealth = manhunt.setPlayerHealth();
        boolean computerGoesFirst = manhunt.goesFirst();

        System.out.println("Computer is choosing a hiding spot...");
        int computerPosition = random.nextInt(9) + 1;
        //System.out.println(computerPosition);

        System.out.println("Choose a position on the grid (1-9)");
        int playerPosition = scanner.nextInt();
        //System.out.println(playerPosition);

        switch(playerPosition){
            case 1:{
                playerField[0][0] = 'O';
                break;
            }
            case 2:{
                playerField[0][2] = 'O';
                break;
            }
            case 3:{
                playerField[0][4] = 'O';
                break;
            }
            case 4:{
                playerField[2][0] = 'O';
                break;
            }
            case 5:{
                playerField[2][2] = 'O';
                break;
            }
            case 6:{
                playerField[2][4] = 'O';
                break;
            }
            case 7:{
                playerField[4][0] = 'O';
                break;
            }
            case 8:{
                playerField[4][2] = 'O';
                break;
            }
            case 9:{
                playerField[4][4] = 'O';
                break;
            }
            default:{
                break;
            }
        }


        if(computerGoesFirst == true){
            attackPlayer(playerField, (random.nextInt(9) + 1));
            System.out.println("Opponent's Field");
            printOpponentField(opponentField);
            System.out.println("---------------------");
            System.out.println("Player's Field");
            printPlayerField(playerField);
            computerGoesFirst = false;
        }


        while(win != true){
            System.out.println("Enter a position to attack (1-9)");
            int playerAttack = scanner.nextInt();
            int computerAttack = random.nextInt(9) + 1;
            attackPlayer(playerField, computerAttack);
            attackOpponent(opponentField, playerAttack);

            System.out.println("Opponent's Field");
            printOpponentField(opponentField);
            System.out.println("---------------------");
            System.out.println("Player's Field");
            printPlayerField(playerField);


            if(playerAttack == computerPosition){
                computerHealth--;
                System.out.println("Computer hit");
            }
            if(computerAttack == playerPosition){
                playerHealth--;
                System.out.println("Player hit");
                switch(playerPosition){
                    case 1:{
                        playerField[0][0] = 'O';
                        break;
                    }
                    case 2:{
                        playerField[0][2] = 'O';
                        break;
                    }
                    case 3:{
                        playerField[0][4] = 'O';
                        break;
                    }
                    case 4:{
                        playerField[2][0] = 'O';
                        break;
                    }
                    case 5:{
                        playerField[2][2] = 'O';
                        break;
                    }
                    case 6:{
                        playerField[2][4] = 'O';
                        break;
                    }
                    case 7:{
                        playerField[4][0] = 'O';
                        break;
                    }
                    case 8:{
                        playerField[4][2] = 'O';
                        break;
                    }
                    case 9:{
                        playerField[4][4] = 'O';
                        break;
                    }
                    default:{
                        break;
                    }
                }
            }


            if(playerHealth == 0){
                System.out.println("You Lose");
                System.out.println("Play Again? (y = 1/n = 0)");
                int input = scanner.nextInt();
                if(input == 1){
                    resetGrid(opponentField, playerField);
                    computerHealth = manhunt.setComputerHealth();
                    playerHealth = manhunt.setPlayerHealth();
                    computerGoesFirst = manhunt.goesFirst();
                    System.out.println("Computer is choosing a hiding spot...");
                    computerPosition = random.nextInt(9) + 1;
                    System.out.println("Choose a position on the grid (1-9)");
                    playerPosition = scanner.nextInt();
                    switch(playerPosition){
                        case 1:{
                            playerField[0][0] = 'O';
                            break;
                        }
                        case 2:{
                            playerField[0][2] = 'O';
                            break;
                        }
                        case 3:{
                            playerField[0][4] = 'O';
                            break;
                        }
                        case 4:{
                            playerField[2][0] = 'O';
                            break;
                        }
                        case 5:{
                            playerField[2][2] = 'O';
                            break;
                        }
                        case 6:{
                            playerField[2][4] = 'O';
                            break;
                        }
                        case 7:{
                            playerField[4][0] = 'O';
                            break;
                        }
                        case 8:{
                            playerField[4][2] = 'O';
                            break;
                        }
                        case 9:{
                            playerField[4][4] = 'O';
                            break;
                        }
                        default:{
                            break;
                        }
                    }
                    if(computerGoesFirst == true){
                        attackPlayer(playerField, (random.nextInt(9) + 1));
                        System.out.println("Opponent's Field");
                        printOpponentField(opponentField);
                        System.out.println("---------------------");
                        System.out.println("Player's Field");
                        printPlayerField(playerField);
                        computerGoesFirst = false;
                    }
                    win = false;
                }else{
                    System.out.println("Have a Nice Day!");
                    win = true;
                }
            }else if(computerHealth == 0){
                System.out.println("You Win!");
                System.out.println("Play Again? (y = 1/n = 0)");
                int input = scanner.nextInt();
                if(input == 1){
                    resetGrid(opponentField, playerField);
                    computerHealth = manhunt.setComputerHealth();
                    playerHealth = manhunt.setPlayerHealth();
                    computerGoesFirst = manhunt.goesFirst();
                    System.out.println("Computer is choosing a hiding spot...");
                    computerPosition = random.nextInt(9) + 1;
                    System.out.println("Choose a position on the grid (1-9)");
                    playerPosition = scanner.nextInt();
                    switch(playerPosition){
                        case 1:{
                            playerField[0][0] = 'O';
                            break;
                        }
                        case 2:{
                            playerField[0][2] = 'O';
                            break;
                        }
                        case 3:{
                            playerField[0][4] = 'O';
                            break;
                        }
                        case 4:{
                            playerField[2][0] = 'O';
                            break;
                        }
                        case 5:{
                            playerField[2][2] = 'O';
                            break;
                        }
                        case 6:{
                            playerField[2][4] = 'O';
                            break;
                        }
                        case 7:{
                            playerField[4][0] = 'O';
                            break;
                        }
                        case 8:{
                            playerField[4][2] = 'O';
                            break;
                        }
                        case 9:{
                            playerField[4][4] = 'O';
                            break;
                        }
                        default:{
                            break;
                        }
                    }
                    if(computerGoesFirst == true) {
                        attackPlayer(playerField, (random.nextInt(9) + 1));
                        System.out.println("Opponent's Field");
                        printOpponentField(opponentField);
                        System.out.println("---------------------");
                        System.out.println("Player's Field");
                        printPlayerField(playerField);
                        computerGoesFirst = false;
                    }
                    win = false;
                }else{
                    System.out.println("Have a Nice Day!");
                    win = true;
                }
            }
        }
    }
}
