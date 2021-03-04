package com.haui.realestatebusiness.repositories;


import com.haui.realestatebusiness.models.entities.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, String> {
}
