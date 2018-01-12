package com.nashtech.musicstore.api;

import com.nashtech.musicstore.controller.BaseController;
import com.nashtech.musicstore.model.Album;
import com.nashtech.musicstore.service.IAlbumService;
import com.nashtech.musicstore.service.IArtistService;
import com.nashtech.musicstore.service.IGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping(value = "/api/album")
public class AlbumControllerApi extends BaseController {

    @Autowired
    IAlbumService albumService;

    @Autowired
    IGenreService genreService;

    @Autowired
    IArtistService artistService;

    @RequestMapping(value = "management-api/create", method = RequestMethod.POST)
    public void addOneAlbum(@RequestBody Album album) {
        album.setImagePath("testImage.abc");
        album.setCreatedAt(new Timestamp(Calendar.getInstance().getTimeInMillis()));
        album.setModifiedAt(new Timestamp(Calendar.getInstance().getTimeInMillis()));
        albumService.saveOrUpdate(album);
    }

    @RequestMapping(value = "/management-api/retrieve", method = RequestMethod.GET)
    public List<Album> getAllAlbums() {
        return albumService.getAll();
    }

    @RequestMapping(value = "/management-api/update/{albumId}", method = RequestMethod.GET)
    public Album getAlbumDetail(@PathVariable("albumId") int albumId) {
        return albumService.find(albumId);
    }

    @RequestMapping(value = "management-api/update", method = RequestMethod.PUT)
    public void updateOneAlbum(@RequestBody Album album) {
        album.setModifiedAt(new Timestamp(Calendar.getInstance().getTimeInMillis()));
        albumService.saveOrUpdate(album);
    }

    @RequestMapping(value = "/management-api/delete/{albumId}", method = RequestMethod.DELETE)
    public void deleteOneAlbum(@PathVariable("albumId") int albumId) {
        Album album = albumService.find(albumId);
        albumService.remove(album);
    }
}
