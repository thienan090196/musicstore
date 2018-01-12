package com.nashtech.musicstore.service;

import com.nashtech.musicstore.model.Genre;
import org.springframework.stereotype.Service;

@Service("genreService")
public class GenreServiceImp extends GenericServiceImp<Genre, Integer> implements IGenreService {
}
