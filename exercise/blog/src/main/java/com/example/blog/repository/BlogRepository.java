package com.example.blog.repository;

import com.example.blog.model.Blog;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class BlogRepository implements IBlogRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Blog> findAll() {
        TypedQuery<Blog> query = entityManager.createQuery("select b from Blog b", Blog.class);
        return query.getResultList();
    }

    @Override
    public Blog findById(long id) {
        TypedQuery<Blog> query = entityManager.createQuery("select b from Blog b where b.id = :id", Blog.class);
        query.setParameter("id", id);
       try {
           return  query.getSingleResult();
       } catch (NoResultException e) {
           return null;
       }
    }

    @Override
    public void save(Blog blog) {
        if (blog != null) {
            entityManager.merge(blog);
        } else {
            entityManager.persist(null);
        }
    }

    @Override
    public void remove(long id) {
        Blog blog = findById(id);
        if (blog != null) {
            entityManager.remove(blog);
        }
    }
}
