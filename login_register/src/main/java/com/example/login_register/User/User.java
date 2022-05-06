package com.example.login_register.User;




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;



import java.time.LocalDateTime;



@Document(collection = "user")
@Data
@AllArgsConstructor

public class User {

    @Id
    private String id;

    private String firstName;

    private String lastName;

    private Integer Age;

    @Field
    @Indexed(unique = true)
    private  String  userName ;

    private String password;

    private LocalDateTime CreateTime =LocalDateTime.now() ;
    private String userRole;
    public User() {}
    public String getId() {return id;}
    public User admin() {
        User admin = new User();
        admin.userName = "admin";
        admin.Age = 27;
        admin.firstName="admin";
        admin.lastName="admin";
        admin.userRole="ADMIN";
        admin.password="12345";
        System.out.println(admin.userName);
        return admin;

    }
    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public Integer getAge() {
        return Age;
    }
    public void setAge(Integer age) {
        Age = age;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public LocalDateTime getCreateTime() {
        return CreateTime;
    }
    public void setCreateTime(LocalDateTime createTime) {
        CreateTime = createTime;
    }
    public void setId(String id) {this.id = id;}
    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}


}
