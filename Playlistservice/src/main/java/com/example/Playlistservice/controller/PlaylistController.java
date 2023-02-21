/*
 * Author : Naveen Kumar
 * Date : 21-02-2023
 * Created With : IntelliJ IDEA Community Edition
 */

package com.example.Playlistservice.controller;

import com.example.Playlistservice.model.Playlist;
import com.example.Playlistservice.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v3")
public class PlaylistController {
    ResponseEntity responseEntity;
    PlaylistService playlistService;
    @Autowired

    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @PostMapping("/playlist")
    public ResponseEntity<?> saveTracks(@RequestBody Playlist playlist) {
        try {
            Playlist user1= playlistService.savePlaylist(playlist);
            return new ResponseEntity<Playlist>(user1, HttpStatus.OK);

        }
        catch (Exception e) {
            System.out.println("exception arised");
            return new ResponseEntity<String>("Error Occured", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/playlists")
    public ResponseEntity<?> getAllPlaylist() {
        try{
            responseEntity=new ResponseEntity(playlistService.getFullList(),HttpStatus.OK);
        }
        catch (Exception e) {
            responseEntity=new ResponseEntity (e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}
