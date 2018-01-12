package com.nashtech.musicstore.dao;

import com.nashtech.musicstore.model.Genre;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository("genreDao")
@Transactional
public class GenreDaoImp extends GenericDaoImp<Genre, Integer> implements IGenreDao {
}
