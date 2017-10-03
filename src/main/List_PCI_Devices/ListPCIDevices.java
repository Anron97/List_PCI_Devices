package main.List_PCI_Devices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ListPCIDevices {

    public static Map<String, String> getListPCI() {
        Process process = null;
        String deviceInfo;
        BufferedReader reader;
        Map<String, String> result = new HashMap<>();
        try {
            process = Runtime.getRuntime().exec("lspci -mmnn");
            reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            while ((deviceInfo = reader.readLine())!=null){
               String[] parse = deviceInfo.split("\"");
               result.put(parse[5], parse[3]);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(process != null) process.destroy();
        }
        return result;
    }
}
