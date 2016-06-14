package uy.edu.ort.achilles.persistence.managers;

import java.util.List;
import javax.ejb.Local;
import uy.edu.ort.achilles.persistence.entities.Article;

@Local
public interface ArticleManagerSBLocal {
    public void nuevoArticulo(Article art);
    public List<Article> getArticles();
}
