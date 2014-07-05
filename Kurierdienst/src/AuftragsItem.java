
public class AuftragsItem {
	
	private int id;
	private String status;
	private String date;
	private String pickUpAddress;
	private String dropOffAddress;
	private String driver;
	
	public AuftragsItem(int id, String status, String date, String pickUpAdress, String dropOffAddress, String driver){
		this.id = id;
		this.status = status;
		this.date = date;
		this.pickUpAddress = pickUpAdress;
		this.dropOffAddress = dropOffAddress;
		this.driver = driver;
	}
	
	public int getId(){
		return id;
	}
	public String getStatus(){
		return status;
	}
	public String getDate(){
		return date;
	}
	public String getPickUpAddress(){
		return pickUpAddress;
	}
	public String getDropOffAddress(){
		return dropOffAddress;
	}
	public String getDriver(){
		return driver;
	}

}
