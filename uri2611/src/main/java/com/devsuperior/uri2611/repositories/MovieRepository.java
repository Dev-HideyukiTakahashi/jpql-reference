package com.devsuperior.uri2611.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.uri2611.dto.MovieMinDTO;
import com.devsuperior.uri2611.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

  /*
   * SQL:
   * 
   * SELECT movies.id, movies.name
   * FROM movies
   * INNER JOIN genres
   * ON movies.id_genres = genres.id
   * WHERE genres.description = 'Action';
   * 
   */

  // JPQL:
  @Query("SELECT new com.devsuperior.uri2611.dto.MovieMinDTO(obj.id, obj.name) "
      + "FROM Movie obj "
      + "WHERE obj.genre.description = :genreName")
  List<MovieMinDTO> searchByGenreName(String genreName);
}
