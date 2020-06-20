package com.cwl.service.part_1;

import java.util.ArrayList;

/**
 * @Description:
 * @Author: HuangDongSheng
 * @Date: 2020/5/31 21:04
 */
public class TicketWindow extends Thread{
    //柜台名称
    private final String name;
    //最多受理50笔记业务
    private static final int MAX = 50;
    private static  int  index = 1;
    private ArrayList<Integer> orderList = new ArrayList<Integer>();

    public TicketWindow(String name){
        this.name = name;
    }

    @Override
    public synchronized  void  run() {
        while (index <= MAX) {
            orderList.add(index);
            System.out.println("柜台：" + name + "当前的号码是：" + (index++));
            if(index>= MAX-15){
                System.out.println("柜台：" + name + " 号码是：" + orderList.toString());
            }
        }
    }

    public  static  void  main(String [] args){
        TicketWindow ticketWindow1= new TicketWindow("一号出号机");
        ticketWindow1.start();

        TicketWindow ticketWindow2= new TicketWindow("二号出号机");
        ticketWindow2.start();

        TicketWindow ticketWindow3= new TicketWindow("三号出号机");
        ticketWindow3.start();

        TicketWindow ticketWindow4= new TicketWindow("四号出号机");
        ticketWindow4.start();

    }

}
