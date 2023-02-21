/*
 * Author : Naveen Kumar
 * Date : 21-02-2023
 * Created With : IntelliJ IDEA Community Edition
 */

package com.niit.userproductservice.service;

import com.niit.userproductservice.model.Playlist;
import com.niit.userproductservice.repo.PlaylistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
