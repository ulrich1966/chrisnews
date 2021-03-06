package de.auli.chrisnews.model;

/**
 * Bildet einen Artikel ab der im JSON in folgender Form auftritt:
 *
 * articles": [
 *     {
 *       "source": {
 *         "id": null,
 *         "name": ""
 *       },
 *       "author": "...",
 *       "title": "...",
 *       "description": "...",
 *       "url": "..."
 *       "urlToImage": "..."
 *       "publishedAt": "...",
 *       "content": "..."
 *       },
 *
 * 'source' ist ein Objekt und wird daher in einer eigenen Klasse definiert. Alle anderen Eintrege
 * sind Membervariablen.
 */
public class Article {
    private String author;
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private String publishedAt;
    private String content;
    private Source source;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return "Article{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", urlToImage='" + urlToImage + '\'' +
                ", publishedAt='" + publishedAt + '\'' +
                ", content='" + content + '\'' +
                ", source=" + source +
                '}';
    }
}
