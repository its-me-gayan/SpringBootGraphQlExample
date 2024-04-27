package org.example.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Builder
@Data
public class UserDto {
    private int id;
    private String username;
    private String firstName;
    private String lastName;
    private String userRole;
//    private java.sql.Date createdAt;
//    private java.sql.Date updatedAt;

}
