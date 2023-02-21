/*
 * Author : Naveen Kumar
 * Date : 21-02-2023
 * Created With : IntelliJ IDEA Community Edition
 */

package com.example.Playlistservice.service;

import com.example.Playlistservice.model.Playlist;
import com.example.Playlistservice.repo.PlaylistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaylistServiceImpl implements PlaylistService{
    @Autowired
    PlaylistRepo playlistRepo;

    public PlaylistServiceImpl(PlaylistRepo playlistRepo) {
        this.playlistRepo = playlistRepo;
    }

    @Override
    public Playlist savePlaylist(Playlist playlist) {
        return playlistRepo.save(playlist);
    }

    @Override
    public List<Playlist> getFullList() {
        return playlistRepo.findAll();
    }
}
