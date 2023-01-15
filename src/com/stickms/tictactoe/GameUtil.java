package com.stickms.tictactoe;

public class GameUtil {
    public static int whoWins(String[] slots, String player){
        String slot = "";
        if (slots[0].equals(slots[1]) && slots[0].equals(slots[2])){
            slot = slots[0];
        }else if (slots[0].equals(slots[3]) && slots[0].equals(slots[6])){
            slot = slots[0];
        }else if (slots[0].equals(slots[4]) && slots[0].equals(slots[8])){
            slot = slots[0];
        }else if (slots[1].equals(slots[4]) && slots[1].equals(slots[7])){
            slot = slots[1];
        }else if (slots[2].equals(slots[4]) && slots[2].equals(slots[6])){
            slot = slots[2];
        }else if (slots[2].equals(slots[5]) && slots[2].equals(slots[8])) {
            slot = slots[2];
        }else if (slots[3].equals(slots[4]) && slots[3].equals(slots[5])){
            slot = slots[3];
        }else if (slots[6].equals(slots[7]) && slots[6].equals(slots[8])){
            slot = slots[6];
        }

        if (slot.equals(player)){
            return 1;
        }else if (slot.equals(player.equals("X") ? "O":"X")){
            return 0;
        }else {
            return -1;
        }
    }
}
