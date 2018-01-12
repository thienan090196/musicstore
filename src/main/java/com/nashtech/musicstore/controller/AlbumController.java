package com.nashtech.musicstore.controller;

import com.nashtech.musicstore.validator.AlbumValidator;
import com.nashtech.musicstore.model.Album;
import com.nashtech.musicstore.service.IAlbumService;
import com.nashtech.musicstore.service.IArtistService;
import com.nashtech.musicstore.service.IGenreService;
import com.nashtech.musicstore.utilities.ConstantValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

@Controller
@RequestMapping(value = "/album")
public class AlbumController extends BaseController {

    @Autowired
    IAlbumService albumService;

    @Autowired
    IGenreService genreService;

    @Autowired
    IArtistService artistService;

    @Autowired
    AlbumValidator albumValidator;

    @RequestMapping(value = "/detail/{albumId}", method = RequestMethod.GET)
    public String detail (@PathVariable("albumId") int albumId,
                          Model model) {
        model.addAttribute("genreList", genreService.getAll());
        model.addAttribute("detail_album", albumService.find(albumId));
        model.addAttribute("title", albumService.find(albumId).getTitle());
        return "detail_album";
    }

    @RequestMapping(value = "/management/all", method = RequestMethod.GET)
    public String all(Model model) {
        model.addAttribute("listModel", albumService.getAll());
        return "admin_list_all_album";
    }

    @RequestMapping(value = "/management/add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("genres_list", genreService.getAll());
        model.addAttribute("artists_list", artistService.getAll());
        Album album = new Album();
        album.setCreatedAt(new Timestamp(Calendar.getInstance().getTimeInMillis()));
        album.setModifiedAt(new Timestamp(Calendar.getInstance().getTimeInMillis()));
        model.addAttribute("album", album);
        return "admin_add_album";
    }

    @RequestMapping(value = "management/save", method = RequestMethod.POST)
    public String save(@Validated @ModelAttribute("album") Album album,
                       BindingResult result, Model model,
                       @RequestParam("file") MultipartFile file,
                       HttpServletRequest request) throws IOException {
//        albumValidator.validate(album, result);
//        for (ObjectError result1:result.getAllErrors()) {
//            System.out.println(result1.getObjectName() + "---" + result1.toString());
//        }
        if (result.hasErrors()) {
            model.addAttribute("genres_list", genreService.getAll());
            model.addAttribute("artists_list", artistService.getAll());
            model.addAttribute("album", album);
            return "admin_add_album";
        }

        if (album.getAlbumId() == null) {
            if (file.isEmpty()) {
                model.addAttribute("genres_list", genreService.getAll());
                model.addAttribute("artists_list", artistService.getAll());
                model.addAttribute("album", album);
                model.addAttribute("imageError", "Image is required");
                return "admin_add_album";
            }
            album.setCreatedAt(new Timestamp(Calendar.getInstance().getTimeInMillis()));
        }

        if (!file.isEmpty()) {
            if (validateFileSize(file.getSize()) && validateFileType(file.getContentType()) && uploadFileSuccess(file, request)) {
                album.setImagePath(ConstantValues.UPLOAD_DIRECTORY + file.getOriginalFilename());
            } else {
                model.addAttribute("imageError", "Invalid image!");
                model.addAttribute("genres_list", genreService.getAll());
                model.addAttribute("artists_list", artistService.getAll());
                model.addAttribute("album", album);
                return "admin_add_album";
            }
        }
        album.setModifiedAt(new Timestamp(Calendar.getInstance().getTimeInMillis()));
        albumService.saveOrUpdate(album);
        return "redirect:/album/management/all";
    }

    @RequestMapping(value = "/management/edit/{albumId}", method = RequestMethod.GET)
    public String update(@PathVariable("albumId") int albumId,
                         Model model) {
        model.addAttribute("genres_list", genreService.getAll());
        model.addAttribute("artists_list", artistService.getAll());
        model.addAttribute("album", albumService.find(albumId));
        return "admin_add_album";
    }

    @RequestMapping(value = "/management/delete/{albumId}", method = RequestMethod.GET)
    public String delete(@PathVariable("albumId") int albumId,
                         Model model) {
        Album album = albumService.find(albumId);
        albumService.remove(album);
        return "redirect:/album/management/all";
    }
}
