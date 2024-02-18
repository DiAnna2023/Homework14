package mobile.mobile.services;

import mobile.mobile.po.ArticlePage;

public class ArticleService {

    private final ArticlePage articlePage = new ArticlePage();

    public String getArticleName() {
        return articlePage
                .clickFirstArticle()
                .getArticleName();
    }

    public ArticlePage getArticle(){
        return articlePage
                .clickFirstArticle();
    }
    public String getArticleHeader(){
        return articlePage
                .getArticleHeader();
    }

    public void clickArticle() {
        articlePage
                .clickFirstArticle();
    }

    public void clickCardRead(){
        articlePage
                .clickElementcardRead();
    }
    public void clickValentineArticle(){
        articlePage
                .clickValentineArticle();
    }
}