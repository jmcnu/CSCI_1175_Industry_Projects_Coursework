public class member {
	private String School;
	private String firstname;
	private String lastname;
	private String grade;
	private java.util.Date dateCreated;

	protected member() {
		dateCreated = new java.util.Date();
	}

	public member(String School, String firstname, String lastname, String grade) {
		dateCreated = new java.util.Date();
		this.School =School;
		this.firstname = firstname;
		this.lastname = lastname;
		this.grade = grade;
	}
	public String getSchool() {
		return School;
	}
	public void setSchool(String School) {
		this.School = School;
	}
	public String getfirstname() {
		return firstname;
	}
	public void setfirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getlastname() {
		return lastname;
	}
	public void setlastname(String lastname) {
		this.lastname =lastname;
	}
	public String getgrade() {
		return grade;
	}
	public void setgrade( String grade) {
		this.grade = grade;
	}
	public java.util.Date getDateCreated() {
		return  dateCreated;
	}
	public String toString() {
		return "created on" + dateCreated;
	}
}

