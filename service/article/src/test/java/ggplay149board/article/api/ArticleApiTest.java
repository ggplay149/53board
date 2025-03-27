package ggplay149board.article.api;

import ggplay149.board.aritcle.service.response.ArticleResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestClient;

public class ArticleApiTest {

    RestClient restClient = RestClient.create("http://localhost:9000");
    static Long TEST_ID;

    @Test
    void createTest() {

        ArticleResponse response = create(new ArticleCreateRequest(
                "hi","my content",1L,1L
        ));
        TEST_ID = response.getArticleId();
        System.out.println("response = " + response);

    }

    ArticleResponse create(ArticleCreateRequest request) {
        return restClient.post()
                .uri("/v1/articles")
                .body(request)
                .retrieve()
                .body(ArticleResponse.class);
    }

    @Test
    void updateTest(){
        ArticleResponse response = update(TEST_ID
                ,new ArticleUpdateRequest("hi-update","my content-update"
                ));
        System.out.println("response = " + response);

    }

    ArticleResponse update(Long articleId,ArticleUpdateRequest request){
        return restClient.put()
                .uri("/v1/articles/{articleId}",articleId)
                .body(request)
                .retrieve()
                .body(ArticleResponse.class);
    }

    @Test
    void readTest(){
        ArticleResponse response = read(TEST_ID);
        System.out.println("response = " + response);

    }

    ArticleResponse read(Long articleId){
        return restClient.get()
                .uri("/v1/articles/{articleId}",articleId)
                .retrieve()
                .body(ArticleResponse.class);
    }

    @Test
    void deleteTest(){
        ArticleResponse response = delete(TEST_ID);
        System.out.println("response = " + response);

    }

    ArticleResponse delete(Long articleId){
        return restClient.delete()
                .uri("/v1/articles/{articleId}",articleId)
                .retrieve()
                .body(ArticleResponse.class);
    }

    @Getter
    @AllArgsConstructor
    static class ArticleCreateRequest {
        private String title;
        private String content;
        private Long writerId;
        private Long boardId;
    }

    @Getter
    @AllArgsConstructor
    static class ArticleUpdateRequest {
        private String title;
        private String content;
    }

}
