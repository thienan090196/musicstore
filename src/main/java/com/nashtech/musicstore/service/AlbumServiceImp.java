package com.nashtech.musicstore.service;

import com.nashtech.musicstore.dao.IAlbumDao;
import com.nashtech.musicstore.model.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("albumService")
public class AlbumServiceImp extends GenericServiceImp<Album, Integer> implements IAlbumService {

    @Autowired
    IAlbumDao albumDao;

    public List<Album> getAllAlbumsByGenreId(int genreId) {
        return albumDao.getAllAlbumsByGenreId(genreId);
    }
}
