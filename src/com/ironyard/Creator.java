package com.ironyard;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Creator {

    public static void main(String args[]) {
        Creator creator = new Creator();
        creator.loopOverWorkOrders();
    }

    public void createWorkOrders() {

        WorkOrder workOrder = new WorkOrder();
        Scanner scanner = new Scanner(System.in);

        workOrder.setStatus(Status.INITIAL);

        System.out.println("Please enter an ID: ");
        workOrder.setId(scanner.nextInt());

        System.out.println("Please enter your name: ");
        workOrder.setSenderName(scanner.next());

        System.out.println("Please enter the description: ");
        workOrder.setDescription(scanner.next());

        ObjectMapper mapper = new ObjectMapper();

        File file = new File(workOrder.getId() + ".json");

        try {
            mapper.writeValue(file, workOrder);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void loopOverWorkOrders() {
        try {
            while (true) {
                createWorkOrders();
                Thread.sleep(5003L);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
