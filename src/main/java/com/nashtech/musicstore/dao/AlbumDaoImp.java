package com.nashtech.musicstore.dao;

import com.nashtech.musicstore.model.Album;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("albumDao")
@Transactional
public class AlbumDaoImp extends GenericDaoImp<Album, Integer> implements IAlbumDao {
    public List<Album> getAllAlbumsByGenreId(int genreId) {
        return currentSession()
                .createCriteria(Album.class)
                .add(Restrictions.eq("genreId", genreId))
                .addOrder(Order.desc("modifiedAt"))
                .addOrder(Order.desc("createdAt"))
                .list();
    }
}
