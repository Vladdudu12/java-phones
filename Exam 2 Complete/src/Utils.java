import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Utils {
	private static List<ElectronicDevices> listElectronicDevices = new ArrayList<>();
	
	public static List<ElectronicDevices> createPhones(int n) throws Exception{
		Utils.listElectronicDevices = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			Utils.listElectronicDevices.add(new Phone());
		}
		
		return Utils.listElectronicDevices;
	}
	
	public static List<ElectronicDevices> readPhones(String file) {
		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			String weight;
			try {
				while((weight = bufferedReader.readLine()) != null) {
					String diagonal = bufferedReader.readLine();
					String producer = bufferedReader.readLine();
					Phone phone = new Phone();
					try {
						phone.setWeight(Float.parseFloat(weight));
						phone.setDiagonal(Double.parseDouble(diagonal));
						phone.setProducer(producer);
					} catch (Exception e) {
						e.printStackTrace();
					}
					listElectronicDevices.add(phone);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			bufferedReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listElectronicDevices;
	}
	
	public static void writeBinaryPhones(String file, List<ElectronicDevices> listP) {
		FileOutputStream binaryOutputStream;
		try {
			binaryOutputStream = new FileOutputStream(file);
			try {
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(binaryOutputStream);
				for(ElectronicDevices ed : listP) {
					objectOutputStream.writeObject(ed);
				}
				objectOutputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			binaryOutputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	 public static List<ElectronicDevices> readBinaryPhones(String file){
		 try {
			FileInputStream binaryInputStream = new FileInputStream(file);
			ObjectInputStream objectInputStream = new ObjectInputStream(binaryInputStream);
			Phone phone;
			
			while((phone = (Phone) objectInputStream.readObject()) != null) {
				listElectronicDevices.add(phone);
			}
			objectInputStream.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		 return listElectronicDevices;
	 }
}
