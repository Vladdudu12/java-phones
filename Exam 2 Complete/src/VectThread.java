import java.util.ArrayList;
import java.util.List;

public class VectThread implements Runnable{
	private List<ElectronicDevices> phoneList = new ArrayList<>();
	private double avgWeight;
	
	
	
	public VectThread(String file) {
		super();
		phoneList = Utils.readBinaryPhones(file);
	}

	public List<ElectronicDevices> getPhoneList() {
		List<ElectronicDevices> listElectronicDevices = new ArrayList<>();
		for(ElectronicDevices ec : phoneList) {
			listElectronicDevices.add(ec);
		}
		return listElectronicDevices;
	}

	public double getAvgWeight() {
		return avgWeight;
	}



	@Override
	public void run() {
		double sum = 0;
		for(ElectronicDevices ec : phoneList) {
			sum += ((Phone) ec).getWeight();
		}
		avgWeight = sum / phoneList.size();
	}
	
}
