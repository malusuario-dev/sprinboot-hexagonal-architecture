package com.camilo.webdemo.common.application.mediator;

public interface RequestHandler<T extends Request<R>, R> {

    R handle(T requst);

    Class<T> getReuestType();

}
