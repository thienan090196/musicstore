package com.nashtech.musicstore.service;

import com.nashtech.musicstore.model.Artist;
import org.springframework.stereotype.Service;

@Service("artistService")
public class ArtistServiceImp extends GenericServiceImp<Artist, Integer> implements IArtistService {
}
