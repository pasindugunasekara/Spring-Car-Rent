package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {


    private String user_id;
    private String name;
    private String email;
    private String password;
    private String address;
    private String contact;
    private String nic;
    private String licen_id;
    private String licen_pic;

//    public UserDTO() {
//    }
//
//    public UserDTO(String user_id, String name, String nic, String address, String contact, String email, String password, String licen_id) {
//        this.user_id = user_id;
//        this.name = name;
//        this.nic = nic;
//        this.address = address;
//        this.contact = contact;
//        this.email = email;
//        this.password = password;
//        this.licen_id = licen_id;
//    }
//
//    public String getUser_id() {
//        return user_id;
//    }
//
//    public void setUser_id(String user_id) {
//        this.user_id = user_id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getNic() {
//        return nic;
//    }
//
//    public void setNic(String nic) {
//        this.nic = nic;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public String getContact() {
//        return contact;
//    }
//
//    public void setContact(String contact) {
//        this.contact = contact;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getLicen_id() {
//        return licen_id;
//    }
//
//    public void setLicen_id(String licen_id) {
//        this.licen_id = licen_id;
//    }
//
//    @Override
//    public String toString() {
//        return "UserDTO{" +
//                "user_id='" + user_id + '\'' +
//                ", name='" + name + '\'' +
//                ", nic='" + nic + '\'' +
//                ", address='" + address + '\'' +
//                ", contact='" + contact + '\'' +
//                ", email='" + email + '\'' +
//                ", password='" + password + '\'' +
//                ", licen_id='" + licen_id + '\'' +
//                '}';
//    }
}
