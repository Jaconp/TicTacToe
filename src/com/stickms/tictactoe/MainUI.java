package com.stickms.tictactoe;

import java.util.Scanner;

public class MainUI {
    public static void main(String[] args){
        boolean game = true;
        String[] slots = new String[9];
        for (int i=0; i<slots.length; i++){
            slots[i] = String.valueOf(i+1);
        }
        Scanner reader = new Scanner(System.in);
        Computer computer;
        gameLoop : while (game){
            StringBuilder builder = new StringBuilder();
            for (int i=0; i< slots.length; i++){
                if ((i+1)%3 != 0){
                    builder.append(" ").append(slots[i]).append(" |");
                }else {
                    builder.append(" ").append(slots[i]).append("\n");
                    if (i != 8){
                        builder.append("___________").append("\n");
                    }
                }
            }
            System.out.println(builder);
            System.out.println("Type in a slot");
            try {
                String typed = reader.nextLine();
                int choice = Integer.parseInt(typed);
                if (choice > slots.length+1 || choice<=0){
                    System.out.println("Type a valid slot please.");
                    continue;
                }
                if (slots[choice-1].equals("X") || slots[choice-1].equals("O")){
                    System.out.println("The slot has already been taken.");
                    continue;
                }
                slots[choice-1] = "X";
                computer = new Computer(slots);
            }catch (NumberFormatException e){
                System.out.println("Type a number please.");
                continue;
            }

            int i = GameUtil.whoWins(slots, "X");
            if (i == 1){
                System.out.println("You won!");
                break;
            }else if (i == 0){
                System.out.println("You lost!");
                break;
            }

            for (String slot : slots) {
                if (!slot.equals("X") && !slot.equals("O")){
                    slots[computer.randomMove()] = "O";
                    int x = GameUtil.whoWins(slots, "X");
                    if (x == 1){
                        System.out.println("You won!");
                        break gameLoop;
                    }else if (x == 0){
                        System.out.println("You lost!");
                        break gameLoop;
                    }
                    continue gameLoop;
                }
            }
            game = false;
            System.out.println("Draw");
        }

        // Final
        StringBuilder builder = new StringBuilder();
        for (int i=0; i< slots.length; i++){
            if ((i+1)%3 != 0){
                builder.append(" ").append(slots[i]).append(" |");
            }else {
                builder.append(" ").append(slots[i]).append("\n");
                if (i != 8){
                    builder.append("___________").append("\n");
                }
            }
        }
        System.out.println(builder);
    }
}
