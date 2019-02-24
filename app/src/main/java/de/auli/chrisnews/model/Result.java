package de.auli.chrisnews.model;

import java.util.List;

/**
 * Das ist die Oberkalasse fuer das JSON-Objekt.
 * Hier wird alles definiert, was hinter der ersten
 * geschweiften Klammer kommt und vor der lettzten
 * geschweiften Klammer endet.
 *
 * U.a haelt die Klasse eine Liste von Artikeln, die im Jason als
 * Array 'articles' auftauchen
 */
public class Result extends Model {
    private String status;
    private Integer totalResults;
    private List<Article> articles;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "RootMod{" +
                "status='" + status + '\'' +
                ", totalResults=" + totalResults +
                ", articles=" + articles +
                '}';
    }
}
