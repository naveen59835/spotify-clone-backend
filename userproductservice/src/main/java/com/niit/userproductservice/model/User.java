/*
 * Author : Naveen Kumar
 * Date : 12-02-2023
 * Created With : IntelliJ IDEA Community Edition
 */

package com.niit.userproductservice.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class User {

    String email;
    String name;

    String phoneNo;
    @Id
    String userId;
    String password;
   Track trackList;

}
