public class HolidayPerson {
	private String name;
	private String[] wishList;
	private boolean isNice;
	private boolean isNaughty;
	
	
	public boolean deservesPresent(boolean isNice, boolean isNaughty){
		if(isNice&&!isNaughty) {
			return true;
		}
		return false;
	}
	
	public void printList(String[] myList) {
		for(int i=0; i<myList.length;i++){
			System.out.println(myList[i]);
		}
	}
	
	//Getters
	public String getName() {
		return name;
	}
	public String[] getWishList() {
		return wishList;
	}
	public boolean isNice() {
		return isNice;
	}
	public boolean isNaughty() {
		return isNaughty;
	}
	
	//Setters
	public void setName(String name) {
		this.name = name;
	}
	public void setWishList(String[] wishList) {
		this.wishList = wishList;
	}
	public void setNice(boolean isNice) {
		this.isNice = isNice;
	}
	public void setNaughty(boolean isNaughty) {
		this.isNaughty = isNaughty;
	}
	
	
	

}
