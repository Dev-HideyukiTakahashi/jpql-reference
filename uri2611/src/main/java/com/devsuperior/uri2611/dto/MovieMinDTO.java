package com.devsuperior.uri2611.dto;

public class MovieMinDTO {

  private Long id;
  private String name;

  public MovieMinDTO() {
  }

  public MovieMinDTO(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return "[id=" + id + ", name=" + name + "]";
  }

}
