package ggplay149.board.aritcle.controller;

import ggplay149.board.aritcle.service.ArticleService;
import ggplay149.board.aritcle.service.request.ArticleCreateRequest;
import ggplay149.board.aritcle.service.request.ArticleUpdateRequest;
import ggplay149.board.aritcle.service.response.ArticleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping("/v1/articles/{articleId}")
    public ArticleResponse read(@PathVariable Long articleId) {
        return articleService.read(articleId);
    }

    @PostMapping("v1/articles")
    public ArticleResponse create(@RequestBody ArticleCreateRequest request) {
        return articleService.create(request);
    }

    @PostMapping("v1/articles/{articleId}")
    public ArticleResponse update(@PathVariable Long articleId, @RequestBody ArticleUpdateRequest request) {
        return articleService.update(articleId, request);
    }

    @DeleteMapping("v1/articles/{articleId}")
    public void delete(@PathVariable Long articleId){
        articleService.delete(articleId);
    }

}
