package com.neuedu.basic1.demo3;

/**
 * @author ldamei
 * @date 2020/2/5 15:43
 */
public class Test1 {
    /**
     *用来存放数据的数组
     */
    private Object[] array;
    /**
     *用来实际放入数组的个数
     */
    private int size;

    public Test1(){
        size = 0;
        array = new Object[10];
    }
    public int getSize() {
        return size;
    }
    public void add(Object i){
        // 如果存放的个数大于数组的长度，则需要扩大容量
        if(size >= array.length){
            //扩大容量的方式，定义个长度更大的数组，把之前的数组复制进去，默认扩大1.5倍
            Object[] newarray = new Object[size + size/2];
            for (int j = 0; j < array.length; j++) {
                newarray[j] = array[j];
            }
            array = newarray;
            System.out.println("扩容完成，新数组长度为："+array.length);
        }
        array[size] = i;
        size++;
    }
    //通过下标取值
    public Object get(int i){
        // 取值范围：0~size-1
        if(i < 0 || i >= size){
            System.out.println("索引错误");
            return -1;
        }
        return array[i];
    }
}
