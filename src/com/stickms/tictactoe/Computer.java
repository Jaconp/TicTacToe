package com.stickms.tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Computer {
    private String[] slots;
    public Computer(String[] slots){
        this.slots = slots;
    }

    public int randomMove(){
        List<Integer> empty = new ArrayList<>();
        for (int i=0;i<slots.length;i++){
            if (!slots[i].equals("X") && !slots[i].equals("O")){
                empty.add(i);
            }
        }
        Random random = new Random();
        return empty.get(random.nextInt(empty.size()));
    }
}
