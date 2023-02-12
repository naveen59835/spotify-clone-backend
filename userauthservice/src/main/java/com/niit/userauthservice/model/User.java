/*
 * Author : Naveen Kumar
 * Date : 11-02-2023
 * Created With : IntelliJ IDEA Community Edition
 */

package com.niit.userauthservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class User {
    @Id
    String userId;
    String password;

}
