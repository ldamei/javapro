package com.neuedu.basic3.demo1;

/**
 * @author ldamei
 * @date 2020/2/6 22:31
 */
public class MainBoard {
    /*private I3 i3;
    public I3 getI3() {
        return i3;
    }
    public void setI3(I3 i3) {
        this.i3 = i3;
    }*/

    private Cpu cpu;

    public Cpu getCpu() {
        return cpu;
    }

    public void setCpu(Cpu cpu) {
        this.cpu = cpu;
    }

    public void method(){
        this.cpu.method();
    }
}
