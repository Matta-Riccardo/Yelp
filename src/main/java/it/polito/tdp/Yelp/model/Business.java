package it.polito.tdp.Yelp.model;

//Vado a mappare in una classe la tabella Business presente nel database
public class Business {

	private String businessId;
	private String fullAddress;
	private String active;
	private String categories;
	private String city;
	private int reviewCount; //posso in alternativa lavorare con un Integer
	private String businessName;
	private String neighborhoods;
	private double latitude;
	private double longitude;
	private String state;
	private double stars;
	
	public Business(String businessId, String fullAddress, String active, String categories, String city,
			int reviewCount, String businessName, String neighborhoods, double latitude, double longitude, String state,
			double stars) {
		super();
		this.businessId = businessId;
		this.fullAddress = fullAddress;
		this.active = active;
		this.categories = categories;
		this.city = city;
		this.reviewCount = reviewCount;
		this.businessName = businessName;
		this.neighborhoods = neighborhoods;
		this.latitude = latitude;
		this.longitude = longitude;
		this.state = state;
		this.stars = stars;
	}

	public String getBusinessId() {
		return businessId;
	}

	public String getFullAddress() {
		return fullAddress;
	}

	public String getActive() {
		return active;
	}

	public String getCategories() {
		return categories;
	}

	public String getCity() {
		return city;
	}

	public int getReviewCount() {
		return reviewCount;
	}

	public String getBusinessName() {
		return businessName;
	}

	public String getNeighborhoods() {
		return neighborhoods;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public String getState() {
		return state;
	}

	public double getStars() {
		return stars;
	}

	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}

	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public void setCategories(String categories) {
		this.categories = categories;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public void setNeighborhoods(String neighborhoods) {
		this.neighborhoods = neighborhoods;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setStars(double stars) {
		this.stars = stars;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((businessId == null) ? 0 : businessId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Business other = (Business) obj;
		if (businessId == null) {
			if (other.businessId != null)
				return false;
		} else if (!businessId.equals(other.businessId))
			return false;
		return true;
	}
	
	
	
}
