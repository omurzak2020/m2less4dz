package com.company;

public class Runner extends Thread {
    private Runner runnerF;
    private Runner runnerS;

    public Runner(String name) {
        super(name);
    }

    public void setRunnerFS(Runner runnerF, Runner runnerS) {
        this.runnerF = runnerF;
        this.runnerS = runnerS;
    }

    @Override
    public synchronized void run() {

        if (getName().equals("Runner5")) {
            System.out.println(getName() + " берет палочку");
            System.out.println(getName() + " бежит к финишу");
            try {
                sleep(500);
            } catch (Exception ignored) {  }
            System.out.println(getName() + " бежит к " + runnerF.getName());
            try {
                sleep(500);
            } catch (Exception ignored) {
            }
        }
        else {
            System.out.println(getName() + " берет палочку");
            System.out.println(getName() + " бежит к " + runnerS.getName());
            try {
                sleep(500);

            } catch (Exception ignored) {
            }

            runnerS.start();
            try {
                runnerS.join();
            } catch (Exception ignored) {
            }
            System.out.println(getName() + " берет палочку");
            try {
                sleep(500);
                if (!getName().equals("Runner5") && !getName().equals("Runner1")) {
                    System.out.println(getName() + " бежит к " + runnerF.getName());
                    try {
                        sleep(500);
                    } catch (Exception ignored) {
                    }
                }
            } catch (Exception ignored) {
            }
        }
    }
}