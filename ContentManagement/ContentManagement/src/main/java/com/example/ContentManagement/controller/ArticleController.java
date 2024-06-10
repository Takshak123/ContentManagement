package com.example.ContentManagement.controller;

import com.example.ContentManagement.model.Article;
import com.example.ContentManagement.service.ArticleService;
import com.example.ContentManagement.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/articles")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @Autowired
    private AuthorService authorService;

    @GetMapping
    public String listArticles(Model model) {
        model.addAttribute("articles", articleService.getAllArticles());
        return "articles/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("article", new Article());
        model.addAttribute("authors", authorService.getAllAuthors());
        return "articles/new";
    }

    @PostMapping
    public String createArticle(@ModelAttribute Article article) {
        articleService.saveArticle(article);
        return "redirect:/articles";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("article", articleService.getArticleById(id));
        model.addAttribute("authors", authorService.getAllAuthors());
        return "articles/edit";
    }

    @PostMapping("/{id}")
    public String updateArticle(@PathVariable Long id, @ModelAttribute Article article) {
        article.setId(id);
        articleService.saveArticle(article);
        return "redirect:/articles";
    }

    @GetMapping("/{id}/delete")
    public String deleteArticle(@PathVariable Long id) {
        articleService.deleteArticle(id);
        return "redirect:/articles";
    }
}
