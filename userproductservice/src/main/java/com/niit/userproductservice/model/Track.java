/*
 * Author : Naveen Kumar
 * Date : 12-02-2023
 * Created With : IntelliJ IDEA Community Edition
 */

package com.niit.userproductservice.model;

import lombok.*;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Track {
    @Id
    String trackId;
    String trackName;
    String musicPath;

}
