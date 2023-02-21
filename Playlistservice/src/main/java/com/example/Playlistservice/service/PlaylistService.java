package com.example.Playlistservice.service;

import com.example.Playlistservice.model.Playlist;

import java.util.List;

public interface PlaylistService {
    Playlist savePlaylist(Playlist playlist);
    List<Playlist> getFullList();
}
