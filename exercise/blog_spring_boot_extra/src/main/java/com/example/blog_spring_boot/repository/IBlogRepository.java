package com.example.blog_spring_boot.repository;

import com.example.blog_spring_boot.model.Blog;
import com.example.blog_spring_boot.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IBlogRepository extends JpaRepository<Blog, Long> {
    @Query(value = "select * from blog where title like :title", nativeQuery = true)
    Page<Blog> findBlogByTitleContaining(Pageable pageable, @Param("title") String title);

    @Query(value = "select * from blog join blog_category on blog.id = blog_category.blog_id where category_id = :categoryId", nativeQuery = true)
    Page<Blog> findBlogByCategoriesContaining(@Param("categoryId") long categoryID, Pageable pageable);
}
