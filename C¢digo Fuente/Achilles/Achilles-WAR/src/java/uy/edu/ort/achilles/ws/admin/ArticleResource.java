package uy.edu.ort.achilles.ws.admin;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import uy.edu.ort.achilles.persistence.entities.Article;
import uy.edu.ort.achilles.persistence.managers.ArticleManagerSBLocal;


@Path("/article")
@Stateless
public class ArticleResource {
     @EJB
    private ArticleManagerSBLocal sb;

    public ArticleResource() {
    }
    
    @GET
    @Produces("application/json")
    public List<Article> getArticles() {
        return sb.getArticles();
    }
    
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Article postJson(Article art) {
        sb.nuevoArticulo(art);
        return art;
    }
}
