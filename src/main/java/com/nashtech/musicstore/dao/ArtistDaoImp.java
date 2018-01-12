package com.nashtech.musicstore.dao;

import com.nashtech.musicstore.model.Artist;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository("artistDao")
@Transactional
public class ArtistDaoImp extends GenericDaoImp<Artist, Integer> implements IArtistDao {
}
