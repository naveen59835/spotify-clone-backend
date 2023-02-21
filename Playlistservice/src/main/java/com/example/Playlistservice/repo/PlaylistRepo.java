package com.example.Playlistservice.repo;

import com.example.Playlistservice.model.Playlist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistRepo  extends JpaRepository<Playlist,String> {
}
