/*
 * Author : Naveen Kumar
 * Date : 21-02-2023
 * Created With : IntelliJ IDEA Community Edition
 */

package com.niit.userproductservice.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Playlist {
    @Id
    private String id;
    private String name;
    private String artist;
    private String duration;
    private String src;
}
