import java.io.Serializable;

public class Phone implements ElectronicDevices, Serializable, Cloneable{
	private float weight;
	private double diagonal;
	private String producer;
	
	public Phone() {
		this.weight = 0.0f;
		this.diagonal = 0.0d;
		this.producer = "";
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) throws Exception {
		if(weight > 0) {
			this.weight = weight;
		}
		else {
			throw new Exception();
		}
	}

	public double getDiagonal() {
		return diagonal;
	}

	public void setDiagonal(double diagonal) throws Exception {
		if(diagonal > 0) {
			this.diagonal = diagonal;
		}
		else {
			throw new Exception();
		}
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) throws Exception {
		if(producer != null && producer.length() > 1) {
			this.producer = producer;
		}
		else {
			throw new Exception();
		}
	}

	@Override
	public String infoDevice() {
		return this.producer;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(this.weight == ((Phone) obj).getWeight() && this.diagonal == ((Phone) obj).getDiagonal() && this.producer.equals(((Phone) obj).getProducer())) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		Phone ph = new Phone();
		ph.weight = this.weight;
		ph.diagonal = this.diagonal;
		ph.producer = this.producer;
		return ph;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Phone [weight=");
		builder.append(weight);
		builder.append(", diagonal=");
		builder.append(diagonal);
		builder.append(", producer=");
		builder.append(producer);
		builder.append("]");
		return builder.toString();
	}
	
	

}
