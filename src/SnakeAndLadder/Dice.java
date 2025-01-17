package SnakeAndLadder;

public class Dice {
    private int numberOfDice;

    Dice(int numberOfDice){
        this.numberOfDice = numberOfDice;
    }
    int rollDice(){
        // Will pick the range from which number has to be generated, + 1 to cover for missing start number
        return (int)(Math.random ()*((6*numberOfDice - numberOfDice))) + 1;
    }

    public int getNumberOfDice() {
        return numberOfDice;
    }

    public void setNumberOfDice(int numberOfDice) {
        this.numberOfDice = numberOfDice;
    }
}
