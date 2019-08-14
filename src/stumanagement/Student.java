
package stumanagement;


public class Student {
    
   private String name, email, department, address;

    public Student(String name, String email, String department, String address) {
        this.name = name;
        this.email = email;
        this.department = department;
        this.address = address;
    }
    
    public Student()
    {
        
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDepartment() {
        return department;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" + "name=" + name + ", email=" + email + ", department=" + department + ", address=" + address + '}';
    }
   
   
    
}
