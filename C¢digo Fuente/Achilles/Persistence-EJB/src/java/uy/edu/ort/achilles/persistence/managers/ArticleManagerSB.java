package uy.edu.ort.achilles.persistence.managers;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import uy.edu.ort.achilles.persistence.entities.Article;

@Stateless
public class ArticleManagerSB implements ArticleManagerSBLocal {
    @PersistenceContext
    EntityManager em;

    @Override
    public List<Article> getArticles() {
        Query query = em.createQuery("SELECT art from Article art");
        List<Article> articles = query.getResultList();
        for (Article artSelected:articles) {
            System.out.println(artSelected.getName());
        }
        return articles;
    }

    @Override
    public void nuevoArticulo(Article art) {
        em.persist(art);
    }
}
