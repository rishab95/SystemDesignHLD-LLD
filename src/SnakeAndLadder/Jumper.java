package SnakeAndLadder;

// Can add checks for snake and ladder, start > end for snake, start < end for ladder.
public class Jumper {
    private int start;
    private int end;

    public Jumper(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}
