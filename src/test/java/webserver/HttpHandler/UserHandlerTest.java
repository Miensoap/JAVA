package webserver.HttpHandler;

import db.Database;
import org.junit.jupiter.api.*;
import webserver.HttpMessage.Request;
import webserver.HttpMessage.Response;
import webserver.TestUtils;

import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

class UserHandlerTest {

    final UserHandler userHandler = new UserHandler();

    @AfterEach
    void clearDB() {
        Database.clear();
    }

    @DisplayName("같은 ID 가입 두번 시나리오")
    @TestFactory
    Collection<DynamicTest> doubleRegistration() {
        Request request = TestUtils.createUserRequest;
        return List.of(
                DynamicTest.dynamicTest("createUser 요청이 들어오면 유저가 DB에 추가되고 , 302 응답을 보낸다", () -> {
                    Response response = userHandler.createUser(request);

                    assertSoftly(softly -> {
                        softly.assertThat(response.getStartLine().toString()).isEqualTo("HTTP/1.1 302 Found");
                        softly.assertThat(Database.findUserById("test").getName()).isEqualTo("test");
                    });
                }),

                DynamicTest.dynamicTest("이미 존재하는 유저 ID 라면 DB에 추가하지 않는다", () -> {
                    int beforeSize = Database.findAll().size();

                    userHandler.createUser(request);

                    assertThat(Database.findAll().size()).isEqualTo(beforeSize);
                })
        );
    }
}