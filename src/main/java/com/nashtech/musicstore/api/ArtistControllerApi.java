package com.nashtech.musicstore.api;

import com.nashtech.musicstore.controller.BaseController;
import com.nashtech.musicstore.model.Artist;
import com.nashtech.musicstore.service.IArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/api/artist")
public class ArtistControllerApi extends BaseController {

    @Autowired
    private IArtistService artistService;

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
    public List<Artist> getAllAlbums() {
        return artistService.getAll();
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
