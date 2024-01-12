package Algorithm.day45;

public class Calculator {
    private int memory;

    public int getMemory(){
        return memory;
    }

    public synchronized void setMemory(int memory) {
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
                this.memory = memory;
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
        }
        System.out.println(Thread.currentThread().getName() + ": " + this.memory);
    }
    public void print(){
        System.out.println("일반메서드 호출");
    }
}
