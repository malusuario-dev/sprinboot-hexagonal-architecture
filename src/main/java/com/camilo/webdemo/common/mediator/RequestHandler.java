package com.camilo.webdemo.common.mediator;

public interface RequestHandler<T extends Request<R>, R> {

    R handle(T requst);

    Class<T> getReuestType();

}
