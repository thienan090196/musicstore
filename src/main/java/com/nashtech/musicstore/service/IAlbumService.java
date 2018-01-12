package com.nashtech.musicstore.service;

import com.nashtech.musicstore.model.Album;

import java.util.List;

public interface IAlbumService extends IGenericService<Album, Integer> {
    List<Album> getAllAlbumsByGenreId(int genreId);
}
