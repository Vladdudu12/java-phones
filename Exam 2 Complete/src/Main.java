import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
    	Phone ph1 = new Phone();
    	SmartPhone sp1 = new SmartPhone();
    	
    	try {
			ph1.setWeight(100);
			ph1.setDiagonal(12);
			ph1.setProducer("Apple");
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	System.out.println(ph1.toString());
    	
    	try {
			Phone ph2 = (Phone) ph1.clone();
			System.out.println(ph1.equals(ph2));
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
    	
    	try {
			sp1.setBatteryDuration(100);
			System.out.println(sp1.infoDevice());
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	try {
			List<ElectronicDevices> listElectronicDevices = new ArrayList<>();
			listElectronicDevices = Utils.createPhones(2);
			for(ElectronicDevices ec : listElectronicDevices) {
				System.out.println(ec);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	try {
			List<ElectronicDevices> listElectronicDevicesFile = new ArrayList<>();
			listElectronicDevicesFile = Utils.readPhones("C:\\Users\\Vlad\\Downloads\\Java\\Java\\Exam 2 Complete\\phonesList.txt");
			for(ElectronicDevices ec : listElectronicDevicesFile) {
				System.out.println(ec);
			}
			
			Utils.writeBinaryPhones("binaryPhones.bin", listElectronicDevicesFile);
			List<ElectronicDevices> listElectronicDevicesFile2 = new ArrayList<>();
			listElectronicDevicesFile2 = Utils.readBinaryPhones("C:\\Users\\Vlad\\Downloads\\Java\\Java\\Exam 2 Complete\\binaryPhones.bin");
			for(ElectronicDevices ec : listElectronicDevicesFile2) {
				System.out.println(ec);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	VectThread vt = new VectThread("C:\\Users\\Vlad\\Downloads\\Java\\Java\\Exam 2 Complete\\binaryPhones.bin");
    	vt.run();
    	System.out.println(vt.getAvgWeight());
    	
    }
}
