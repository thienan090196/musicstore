package com.nashtech.musicstore.dao;

import com.nashtech.musicstore.model.Album;

import java.util.List;

public interface IAlbumDao extends IGenericDao<Album, Integer> {
    List<Album> getAllAlbumsByGenreId(int genreId);
}
