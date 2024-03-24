package webserver.HttpHandler.Mapping;

import webserver.HttpHandler.Handler;
import application.handler.LoginHandler;
import webserver.HttpHandler.ResourceHandler;
import application.handler.UserHandler;
import webserver.HttpMessage.Request;
import webserver.HttpMessage.RequestStartLine;
import webserver.HttpMessage.Response;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;

import static webserver.HttpMessage.constants.WebServerConst.*;

public class MappingMatcher {
    private final List<Handler> handlers = new ArrayList<>();

    public MappingMatcher(List<Handler> appHandlers) {
        // default
        this.handlers.add(new ResourceHandler());

        // application handlers
        this.handlers.addAll(appHandlers);
    }

    public Response getResponse(Request request) throws Exception {
        RequestStartLine startLine = request.getStartLine();

        final String httpMethod = startLine.getMethod();
        final String path = startLine.getUri().split(QUERY_START)[0];

        if (httpMethod.equals(GET)) {
            return handleRequest(request, path, this::matchGetMapping);
        }
        if (httpMethod.equals(POST)) {
            return handleRequest(request, path, this::matchPostMapping);
        } else throw new IllegalAccessException("설정되어 있지 않은 http 메소드입니다.");
    }

    private Response handleRequest(Request request , String uri, BiPredicate<Method, String> matchMapping) throws Exception {
        for(Handler handler : handlers) {
            for (Method method : handler.getClass().getDeclaredMethods()) {
                if (matchMapping.test(method, uri)) {
                    return (Response) method.invoke(handler, request);
                }
            }
        }
        // default : get Resource
        return handleRequest(request , "/" , matchMapping);
    }

    private boolean matchGetMapping(Method method, String uri) {
        if (method.isAnnotationPresent(GetMapping.class)) {
            String path = method.getAnnotation(GetMapping.class).path();
            return path.equals(uri);
        }
        return false;
    }

    private boolean matchPostMapping(Method method, String uri) {
        if (method.isAnnotationPresent(PostMapping.class)) {
            String path = method.getAnnotation(PostMapping.class).path();
            return path.equals(uri);
        }
        return false;
    }
}
