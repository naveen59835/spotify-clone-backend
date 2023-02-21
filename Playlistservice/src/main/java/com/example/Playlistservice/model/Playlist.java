/*
 * Author : Naveen Kumar
 * Date : 21-02-2023
 * Created With : IntelliJ IDEA Community Edition
 */

package com.example.Playlistservice.model;

import lombok.*;
import javax.persistence.Id;

import javax.persistence.Entity;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Playlist {
    @Id
    String trackId;
    String trackName;
    String artistName;
    String duration;
    String imgsrc;
}
