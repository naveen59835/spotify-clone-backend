package com.niit.userproductservice.repo;

import com.niit.userproductservice.model.Playlist;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistRepo extends MongoRepository<Playlist,String> {



}
