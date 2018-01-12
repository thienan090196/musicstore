package com.nashtech.musicstore.api;

import com.nashtech.musicstore.controller.BaseController;
import com.nashtech.musicstore.model.Album;
import com.nashtech.musicstore.model.Genre;
import com.nashtech.musicstore.service.IGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping(value = "/api/genre")
public class GenreControllerApi extends BaseController {

    @Autowired
    private IGenreService genreService;

//    @RequestMapping(value = "management-api/create", method = RequestMethod.POST)
//    public void addOneAlbum(@RequestBody Album album) {
//        album.setGenre(genreService.find(1));
//        album.setArtist(artistService.find(1));
//        album.setImagePath("testImage.abc");
//        album.setCreatedAt(new Timestamp(Calendar.getInstance().getTimeInMillis()));
//        album.setModifiedAt(new Timestamp(Calendar.getInstance().getTimeInMillis()));
//        albumService.saveOrUpdate(album);
//    }
//
    @RequestMapping(value = "/management-api/retrieve", method = RequestMethod.GET)
    public List<Genre> getAllAlbums() {
        return genreService.getAll();
    }
//
//    @RequestMapping(value = "/management-api/update/{albumId}", method = RequestMethod.GET)
//    public Album getAlbumDetail(@PathVariable("albumId") int albumId) {
//        return albumService.find(albumId);
//    }
//
//    @RequestMapping(value = "/management-api/delete/{albumId}", method = RequestMethod.DELETE)
//    public void deleteOneAlbum(@PathVariable("albumId") int albumId) {
//        Album album = albumService.find(albumId);
//        albumService.remove(album);
//    }
}
