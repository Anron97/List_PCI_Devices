package main;

import main.List_PCI_Devices.ListPCIDevices;

import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<String, String> listPCI = ListPCIDevices.getListPCI();

        for(String key: listPCI.keySet()){
            System.out.println( "DeviceID: " + key + "\t\t VendorID: " + listPCI.get(key));
        }
        ListPCIDevices.getListPCI();
    }
}
