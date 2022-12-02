public class College extends member{
	private String firstname;
	private String lastname;
	private String year;
	
	 public College() {
		
	}
		public College(String firstname, String lastname, String year) {
			this.firstname = firstname;
			this.lastname = lastname;
			this.year = year;
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
			this.lastname = lastname;
		}
		public String getyear() {
			return year;
		}
		public void setyear(String year) {
			this.year = year;
		}
		public String toString() {
			return "First name:" + firstname + "\tLast name:" + lastname + "\tyear:" + year +"\n";
		}
}

