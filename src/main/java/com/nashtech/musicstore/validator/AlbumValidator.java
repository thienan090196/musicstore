package com.nashtech.musicstore.validator;

import com.nashtech.musicstore.model.Album;
import com.nashtech.musicstore.model.Artist;
import com.nashtech.musicstore.model.Genre;
import org.springframework.beans.TypeMismatchException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.math.BigDecimal;
import java.util.InputMismatchException;

@Component
public class AlbumValidator implements Validator {

    public boolean supports(Class<?> aClass) {
        return Album.class.isAssignableFrom(aClass);
    }

    public void validate(Object object, Errors errors) {
//        Album album = (Album) object;
//
//        //Validate required fields
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "album.title.required");
//
////        Integer genreId = album.getGenre().getGenreId();
////        Integer artistId = album.getArtist().getArtistId();
//        String title = album.getTitle().trim();
//        BigDecimal price = album.getPrice();
//
//        if (price == null) {
//            errors.rejectValue("price", "album.price.required");
//        } else {
//            if (price.compareTo(new BigDecimal(0)) == -1) {
//                errors.rejectValue("price", "album.price.invalid");
//            }
//        }
//
//        String pattern = "^[A-Za-z0-9 ]+$";
//        if (!title.matches(pattern)) {
//            errors.rejectValue("title", "album.title.invalid");
//        }
    }
}
