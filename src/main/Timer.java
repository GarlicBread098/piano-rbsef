package src.main;

public class Timer {

    long startTime;
    long elapsedTime;


    public Timer(){

    }


    public void startTimer(){
        startTime = System.currentTimeMillis();
        elapsedTime = 0;
    }

    public long getTime(){
        elapsedTime = System.currentTimeMillis() - startTime;
        return elapsedTime;
    }

    public void resetTimer(){
        startTime = 0;
        elapsedTime = 0;
    }
}
