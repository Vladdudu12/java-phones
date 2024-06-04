
public class SmartPhone extends Phone{
	private int batteryDuration;

	public int getBatteryDuration() {
		return batteryDuration;
	}

	public void setBatteryDuration(int batteryDuration) throws Exception {
		if(batteryDuration > 0) {
			this.batteryDuration = batteryDuration;
		}
		else {
			throw new Exception();
		}
	}
	
	@Override
	public String infoDevice() {
		return String.format("%d", batteryDuration);
	}
}
